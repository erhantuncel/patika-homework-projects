package com.booklist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class App {

	public static void main(String[] args) {
		
		// Creating book list 
		ArrayList<Book> bookList = new ArrayList<Book>();
		populateBookList(bookList);
		printBookList(bookList, "Initial Book List");
		
		// Creating hashmap with book name and author
		HashMap<String,String> bookMap = new HashMap<String, String>();
		bookList.stream().forEach(book -> bookMap.put(book.getName(), book.getAuthorName()));
		printMap(bookMap, "Map<String, String>");
		
		// Creating list that has books with page count is greater than 100
		List<Book> bookListPageCountGreaterThan100 = 
				bookList.stream().filter(book -> book.getPageCount() > 100).toList();
		printBookList(bookListPageCountGreaterThan100, "Books has page count greater than 100");
	}

	private static void populateBookList(ArrayList<Book> bookList) {
		for(int i=0; i<10; i++) {
			String name = "Book" + (i+1);
			String authorName = "Author" + (i+1);
			int pageCount = generateRandomNumberBetween(1, 1000);
			if(i % 2 == 0) {				
				pageCount = generateRandomNumberBetween(1, 99);
			}
			int releaseYear = generateRandomNumberBetween(1900, 2022);
			bookList.add(new Book(name, pageCount, authorName, releaseYear));
		}
	}
	
	public static void printBookList(List<Book> bookList, String title) {
		System.out.println("\n" + title);
		System.out.println("============================================================");
		System.out.printf("%-13s | %-13s | %-12s | %-15s\n", 
				"Name", "Author", "Release Year", "Page Count");
		System.out.println("------------------------------------------------------------");
		bookList.forEach(book -> System.out.printf("%-13s | %-13s | %-12d | %-15d\n", 
					book.getName(), book.getAuthorName(), book.getReleaseYear(), book.getPageCount()));	
	}
	
	public static void printMap(Map<String, String> map, String title) {
		System.out.println("\n" + title);
		System.out.println("============================================================");
		System.out.printf("%-13s | %-13s\n", 
				"Name", "Author");
		System.out.println("-------------------------");
		map.entrySet().stream().forEach(entry -> System.out.printf("%-13s | %-13s\n", 
															entry.getKey(), entry.getValue()));
	}
	
	public static int generateRandomNumberBetween(int start, int end) {
		Random random = new Random();
		return random.nextInt(end - start) + start;
	}
}
