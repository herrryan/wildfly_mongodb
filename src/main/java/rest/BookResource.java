package rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;

import data.BookRepository;
import model.Book;

@Path("/books")
public class BookResource {

	@Inject
	private BookRepository repository;
	
	@Inject
	private Logger logger;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listUsers(){
		List<Book> result = repository.query();
		logger.info("Got full list of users");
		return Response.ok(result).build();
	}
}
