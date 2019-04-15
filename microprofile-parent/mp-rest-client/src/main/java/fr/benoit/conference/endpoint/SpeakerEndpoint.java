package fr.benoit.conference.endpoint;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import fr.benoit.conference.client.ClientSpeakers;

@Path("/recherche")
@RequestScoped
public class SpeakerEndpoint {

	@Inject
	@RestClient
	ClientSpeakers speakersCdi;
	
	@GET
	@Path("/conferenciers")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> getNomSpeakers() throws MalformedURLException {
		URL urlApi = new URL("http://bordeauxjug.org");
		ClientSpeakers speakers = RestClientBuilder.newBuilder().baseUrl(urlApi).build(ClientSpeakers.class);

		return speakers.getSpeakers()
			.stream()
			.map(s -> s.getFirstName() + " " + s.getLastName())
			.collect(Collectors.toCollection(ArrayList::new));
	}
	
	@GET
	@Path("/conferenciers/parCDI")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> getNomSpeakersByCdi() throws MalformedURLException {
		return speakersCdi.getSpeakers()
			.stream()
			.map(s -> s.getFirstName() + " " + s.getLastName())
			.collect(Collectors.toCollection(ArrayList::new));
	}

}
