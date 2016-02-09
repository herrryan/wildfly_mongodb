package resource;

import javax.enterprise.context.ApplicationScoped;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

import model.Book;

@ApplicationScoped
public class EntityManager {
	
	private MongoClient mongo;
	private Datastore ds;
	private Morphia morphia;

	public EntityManager() {

		try {
			morphia = new Morphia();
			morphia.map(Book.class);
			mongo = new MongoClient("localhost", 27017);
			ds = morphia.createDatastore(mongo, "javaee7");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		System.out.println("Mongo Datastore initialized");
	}

	public Datastore getDs() {
		return ds;
	}

}
