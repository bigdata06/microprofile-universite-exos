package fr.benoit.conference.endpoint;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

@Path("/hello")
public class HelloEndPoint {

	@GET
	@Path("/{prenom}")
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello(@PathParam("prenom") String prenom) {
		return "Hello " + prenom;
	}
	
	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	@APIResponse(responseCode="200", description="Indivu trouvée dans l'annuaire")
	@APIResponse(responseCode="404", description="Individu non trouvée")
	public JsonObject sayHelloJson() {
		JsonObjectBuilder builder = Json.createObjectBuilder();
		builder.add("message", "Hello World");
		
		return builder.build();
	}
	
	@GET
	@Path("/response")
	@Produces(MediaType.APPLICATION_JSON)
	public Response sayHelloResponse() {
		return Response.ok("Hello World").build();
	}
}
