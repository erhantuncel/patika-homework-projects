package com.listclass;

public class MyList<T> {

	private T[] array;
	
	@SuppressWarnings("unchecked")
	public MyList() {
		this.array = (T[]) new Object[10];
	}
	
	@SuppressWarnings("unchecked")
	public MyList(int capacity) {
		this.array = (T[]) new Object[capacity];
	}

	public int size() {
		int countOfElement = 0;
		for(T element : this.array) {
			if(element != null) {
				countOfElement++;
			}
		}
		return countOfElement;
	}
	
	public int getCapacity() {
		return array.length;
	}
	
	@SuppressWarnings("unchecked")
	public void add(T data) {
		if(this.size() == this.array.length) {
			T[] doubledArray = (T[]) new Object[array.length * 2];
			for(int i=0; i<array.length; i++) {
				doubledArray[i] = array[i];
			}
			this.array = doubledArray;
		}
		array[this.size()] = data;
	}
	
	public T get(int index) {
		try {
			return this.array[index];
		} catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}
	}
	
	public T[] remove(int index) {
		try {
			for(int i=index; i<array.length-1; i++) {
				array[i] = array[i+1];
			}
			return array;
		} catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}
	}
	
	public T[] set(int index, T data) {
		try {
			array[index] = data;
			return array;
		} catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}
	}
	
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		if(size() != 0) {			
			stringBuilder.append("[");
			for(int i=0; i<size(); i++) {			
				if(!array[i].equals(array[size()-1])) {				
					stringBuilder.append(array[i] + "-");
				}
			}
			stringBuilder.append(array[size()-1] + "]");
		} else {
			stringBuilder.append("[]");
		}
		return stringBuilder.toString();
	}
	
	public int indexOf(T data) {
		for(int i=0; i<size(); i++) {
			if(array[i].equals(data)) {
				return i;
			}
		}
		return -1;
	}
	
	public int lastIndexOf(T data) {
		for(int i=size()-1; i>=0; i--) {
			if(array[i].equals(data)) {
				return i;
			}
		}
		return -1;
	}
	
	public MyList<T> subList(int start, int finish) {
		MyList<T> subList = new MyList<T>();
		for(int i=start; i<=finish; i++) {
			subList.add(array[i]);
		}
		return subList;
	}
	
	public boolean isEmpty() {
		if(size() == 0) {
			return true;
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public T[] toArray() {
		
		T[] arrayToReturn = (T[]) new Object[array.length];
		for(int i=0; i<arrayToReturn.length; i++) {
			arrayToReturn[i] = array[i];
		}
		return arrayToReturn;
		
	}
	
	public boolean contains(T data) {
		for(int i=0; i<size(); i++) {
			if(array[i].equals(data)) {
				return true;
			}
		}
		return false;
	}
	
	public void clear() {
		int size = size();
		for(int i=0; i<size; i++) {
			array[i] = null;
		}
	}
}
