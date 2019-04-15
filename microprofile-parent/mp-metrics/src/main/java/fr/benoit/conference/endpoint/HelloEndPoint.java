package fr.benoit.conference.endpoint;

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

import org.eclipse.microprofile.metrics.Counter;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Metric;
import org.eclipse.microprofile.metrics.annotation.Timed;

@Path("/hello")
@RequestScoped
public class HelloEndPoint {

	@Inject
	@Metric(name="sayHello")
	Counter cpt;
	
	@GET
	@Path("/{prenom}")
	@Produces(MediaType.TEXT_PLAIN)
	@Counted(name="sayHello", absolute=true, reusable=true, monotonic=true)
	public String sayHello(@PathParam("prenom") String prenom) {
		return "Hello " + prenom;
	}
	
	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public JsonObject sayHelloJson() {
		cpt.inc();
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
	
	@Timed
	@GET
	@Path("/patience")
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHelloAfter() {
		long rand = (long)(Math.random() * 10);
		try {
			Thread.sleep(rand * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return String.format("Bonjour avec un peu de patience (%ds)", rand);
	}
}
