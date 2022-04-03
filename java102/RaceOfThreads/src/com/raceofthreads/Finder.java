package com.raceofthreads;

import java.util.ArrayList;
import java.util.List;

public class Finder implements Runnable {

	public static List<Integer> evenNumbers = new ArrayList<Integer>();
	public static List<Integer> oddNumbers = new ArrayList<Integer>();
	
	private List<Integer> source;

	public Finder(List<Integer> source) {
		super();
		this.source = source;
	}

	@Override
	public void run() {
		synchronized (evenNumbers) {
			for(int i=0; i<source.size(); i++) {
				int number = source.get(i);
				if(number % 2 == 0) {
					evenNumbers.add(number);
					System.out.println(Thread.currentThread().getName() + "-" + number + " => even");
				} else {
					oddNumbers.add(number);
					System.out.println(Thread.currentThread().getName() + "-" + number + " => odd");
				}
			}
		}
	}


}
