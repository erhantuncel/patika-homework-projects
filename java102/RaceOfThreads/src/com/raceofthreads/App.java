package com.raceofthreads;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) throws InterruptedException {
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for(int i=0; i<10000; i++) {
			numbers.add(i+1);
		}
		
		List<Integer> subNumberList1 = numbers.subList(0, 2500);
		List<Integer> subNumberList2 = numbers.subList(2500, 5000);
		List<Integer> subNumberList3 = numbers.subList(5000, 7500);
		List<Integer> subNumberList4 = numbers.subList(7500, 10000);		
		
		Finder finder1 = new Finder(subNumberList1);
		Finder finder2 = new Finder(subNumberList2);
		Finder finder3 = new Finder(subNumberList3);
		Finder finder4 = new Finder(subNumberList4);
		
		Thread t1 = new Thread(finder1);
		Thread t2 = new Thread(finder2);
		Thread t3 = new Thread(finder3);
		Thread t4 = new Thread(finder4);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		t1.join();
		t2.join();
		t3.join();
		t4.join();
		
		System.out.println("------------------------------------------");
		System.out.println("Even numbers list size: " + Finder.evenNumbers.size());
		System.out.println("Odd numbers list size: " + Finder.oddNumbers.size());
		
	}
}
