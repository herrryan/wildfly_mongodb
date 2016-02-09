package model;

import java.io.Serializable;

import javax.persistence.Entity;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Id;

import lombok.Data;

@Data
@Entity
public class Book implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private ObjectId id;
	
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
