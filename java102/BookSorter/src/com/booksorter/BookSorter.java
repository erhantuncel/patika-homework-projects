package com.booksorter;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class BookSorter {

	public static void main(String[] args) {
		
		Comparator<Book> orderByPageCount = new Comparator<Book>() {
			public int compare(Book b1, Book b2) {
				return b1.getPageCount() - b2.getPageCount();
			}
		};
		
		Set<Book> books = new TreeSet<Book>();
		books.add(new Book("The Java Complete Reference", 1248, "Herbert Schildt", 2019));
		books.add(new Book("Introduction to Algorithms", 1292, "Charles E. Cormen", 2009));
		books.add(new Book("Professional JavaScript for Web Developers", 1200, "Matt Frisbie", 2019));
		books.add(new Book("Beginning Angular with Typescript", 198, "Greg Lim", 2018));
		books.add(new Book("Spring Boot in Action", 264, "Craig Walls", 2015));
		
		System.out.println("Order By Name (A to Z)");
		System.out.println("==============================================================================================");
		printBookSet(books);
		
		Set<Book> books2 = new TreeSet<Book>(orderByPageCount);
		books2.addAll(books);
		
		System.out.println("\n\nOrder By Page Count");
		System.out.println("==============================================================================================");
		printBookSet(books2);
	}
	
	public static void printBookSet(Set<Book> books) {
		System.out.printf("%-43s | %-18s | %-12s | %-15s\n", 
					"Name", "Author", "Release Year", "Page Count");
		System.out.println("----------------------------------------------------------------------------------------------");
		for (Book book : books) {
			System.out.printf("%-43s | %-18s | %-12d | %-15d\n", 
					book.getName(), book.getAuthor(), book.getReleaseYear(), book.getPageCount());
		}
	}
}
