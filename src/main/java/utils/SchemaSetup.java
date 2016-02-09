package utils;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import model.Book;
import resource.EntityManager;

@Startup
@Singleton
public class SchemaSetup {

	@Inject
	private EntityManager em;

	@PostConstruct
	public void createSchema() {
		try {

			Book[] books = new Book[5];
			books[0] = new Book("A Tale Of Two Cities", "Charles Dickens","Novel", 10);
			books[1] = new Book("Le Petit Prince", "Antoine de Saint-Exupery","Novel", 8);
			books[2] = new Book("The Da Vinci Code", "Dan Brown", "thriller", 12);
			books[3] = new Book("Think and Grow Rich", "Napoleon Hill","Motivational", 10);
			books[4] = new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", 8);
			em.getDs().getCollection(Book.class).drop();
			em.getDs().save(books);

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}
}
