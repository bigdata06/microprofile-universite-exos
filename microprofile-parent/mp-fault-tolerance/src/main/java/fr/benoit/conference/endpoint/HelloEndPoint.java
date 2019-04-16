package fr.benoit.conference.endpoint;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.benoit.conference.service.BadService;

@Path("/hello")
public class HelloEndPoint {

	@Inject
	BadService service;
	
	@GET
	@Path("/{prenom}")
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello(@PathParam("prenom") String prenom) {
		long rand = service.methodeSuperLongue();
		return String.format("Hello %s (%d s)",prenom,rand);
	}
	
	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public JsonObject sayHelloJson() {
		BadService.nbFois=0;
		int nb= service.methodePasFiable();
		JsonObjectBuilder builder = Json.createObjectBuilder();
		builder.add("message", "Hello World");
		builder.add("nb", nb);
		builder.add("nbFois", BadService.nbFois);
		
		return builder.build();
	}
	
	@GET
	@Path("/response")
	@Produces(MediaType.APPLICATION_JSON)
	public Response sayHelloResponse() {
		return Response.ok("Hello World").build();
	}
}
