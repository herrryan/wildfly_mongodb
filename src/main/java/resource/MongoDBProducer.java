package resource;

import java.net.UnknownHostException;

import javax.enterprise.inject.Produces;

import com.mongodb.MongoClient;

public class MongoDBProducer {
	@Produces
	public MongoClient mongoClient() {
		try {
			return new MongoClient("localhost", 27017);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return null;
	}
}
