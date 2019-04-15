package fr.benoit.conference.endpoint;

import java.util.List;

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

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/hello")
@RequestScoped
public class HelloEndPoint {

	@Inject
	@ConfigProperty(name="ville",defaultValue="Amiens")
	String pville;
	
	@Inject
	@ConfigProperty(name="villes",defaultValue="")
	List<String> pvilles;
	
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
		for (String iville : pvilles) {
			builder.add("message-"+iville, "Hello " + iville);
		}
		builder.add("ville", "" + pville);
		
		return builder.build();
	}
	
	@GET
	@Path("/response")
	@Produces(MediaType.APPLICATION_JSON)
	public Response sayHelloResponse() {
		Config cfg = ConfigProvider.getConfig();
		String cville = cfg.getValue("ville", String.class);
		
		return Response.ok("Hello " + cville).build();
	}
}
