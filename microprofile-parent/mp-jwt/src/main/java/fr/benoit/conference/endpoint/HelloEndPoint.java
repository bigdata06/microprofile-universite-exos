package fr.benoit.conference.endpoint;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
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

import org.eclipse.microprofile.jwt.JsonWebToken;

@Path("/hello")
@RequestScoped
public class HelloEndPoint {

	@Inject
	JsonWebToken token;
	
	@GET
	@Path("/{prenom}")
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello(@PathParam("prenom") String prenom) {
		return "Hello " + prenom;
	}
	
	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public JsonObject sayHelloJson() {
		JsonObjectBuilder builder = Json.createObjectBuilder();
		builder.add("message", "Hello World");
		
		if (token != null) {
			builder.add("username", token.getName());
		}
		return builder.build();
	}
	
	@GET
	@Path("/response")
	@Produces(MediaType.APPLICATION_JSON)
	@RolesAllowed("admin")
	public Response sayHelloResponse() {
		return Response.ok("Hello World").build();
	}
}
