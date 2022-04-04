package com.booklist;

public class Book {

	private String name;
	private int pageCount;
	private String authorName;
	private int releaseYear;

	public Book(String name, int pageCount, String authorName, int releaseYear) {
		super();
		this.name = name;
		this.pageCount = pageCount;
		this.authorName = authorName;
		this.releaseYear = releaseYear;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
}
