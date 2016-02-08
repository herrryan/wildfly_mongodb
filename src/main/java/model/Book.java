package model;

import lombok.Data;

@Data
public class Book {
	String title;
	String author;
	String type;
	int price;
	int copies;

	public Book() { }

	public Book(String title, String author, String type, int price) {
		super();
		this.title = title;
		this.author = author;
		this.type = type;
		this.price = price;
		this.copies = 10;
	}

}
