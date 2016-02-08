package data;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import model.Book;

@Model
public class BookRepository {

	@Inject
	private MongoClient mongoClient;

	List<Book> listBooks;

	String filter;

	@PostConstruct
	private void init() {
		doQuery();
	}

	public void doQuery() {
		listBooks = query();
	}
	public List<Book> query() {
		Gson gson = new Gson();

		DB db = mongoClient.getDB("javaee7");

		DBCollection coll = db.getCollection("bookstore");
		DBCursor cursor = null;
		if (filter == null || filter.trim().length() == 0) {
			cursor = coll.find();   
		}
		else {
			BasicDBObject q = new BasicDBObject();
			q.put("title",  java.util.regex.Pattern.compile(filter));
			cursor = coll.find(q);
		}


		List<Book> list = new ArrayList<Book>();
		try {
			while (cursor.hasNext()) {
				DBObject obj = cursor.next();

				list.add(gson.fromJson(obj.toString(), Book.class));

			}
		} finally {
			cursor.close();
		}
		return list;
	}



}
