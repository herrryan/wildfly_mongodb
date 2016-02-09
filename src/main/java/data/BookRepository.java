package data;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;


import model.Book;
import resource.EntityManager;

@Model
public class BookRepository {

	@Inject
	private EntityManager em;

	public List<Book> query() {
		return em.getDs().createQuery(Book.class).asList();
	}
}
