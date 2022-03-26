package com.listclass;

public class ListClassMain {

	public static void main(String[] args) {
		
		System.out.println("------------------------------------------------------");
		MyList<Integer> list = new MyList<>();
        System.out.println("Count of element in list: " + list.size());
        System.out.println("Capacity of list : " + list.getCapacity());
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        System.out.println("Count of element in list: " + list.size());
        System.out.println("Capacity of list : " + list.getCapacity());
        list.add(50);
        list.add(60);
        list.add(70);
        list.add(80);
        list.add(90);
        list.add(100);
        list.add(110);
        System.out.println("Count of element in list: " + list.size());
        System.out.println("Capacity of list : " + list.getCapacity());
        System.out.println("------------------------------------------------------");
        
        MyList<Integer> list2 = new MyList<>();
        list2.add(10);
        list2.add(20);
        list2.add(30);
        System.out.println("Value of at 2. index : " + list2.get(2));
        System.out.println("Value of at 3. index : " + list2.get(3));
        list2.remove(2);
        list2.add(40);
        list2.set(0, 100);
        System.out.println("Value of at 2. index : " + list2.get(2));
        System.out.println(list2.toString());
        System.out.println("------------------------------------------------------");
        
        MyList<Integer> list3 = new MyList<>();
        System.out.println("List state : " + (list3.isEmpty() ? "Empty" : "Not Empty"));
        list3.add(10);
        list3.add(20);
        list3.add(30);
        list3.add(40);
        list3.add(20);
        list3.add(50);
        list3.add(60);
        list3.add(70);
        
        System.out.println("List state : " + (list3.isEmpty() ? "Empty" : "Not Empty"));

        System.out.println("Index : " + list3.indexOf(20));
        System.out.println("Index :" + list3.indexOf(100));
        System.out.println("Last Index : " + list3.lastIndexOf(20));
        Object[] objectArray = list3.toArray();
        System.out.println("First element of objectArray :" + objectArray[0]);
        MyList<Integer> mySubList = list3.subList(0, 3);
        System.out.println(mySubList.toString());
        System.out.println("20 is in the list : " + list3.contains(20));
        System.out.println("120 is in the list : " + list3.contains(120));
        list3.clear();
        System.out.println(list3.toString());
        
        System.out.println("------------------------------------------------------");
		
	}
}
