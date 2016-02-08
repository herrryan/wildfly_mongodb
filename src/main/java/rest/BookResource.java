package rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import data.BookRepository;
import lombok.extern.slf4j.Slf4j;
import model.Book;

@Path("/books")
@Slf4j
public class BookResource {

	@Inject
	private BookRepository repository;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listUsers(){
		List<Book> result = repository.query();
		return Response.ok(result).build();
	}
}
