package start.project1;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/places")
public class PlacesController {
	@Autowired
	private DataStore dataStore;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPlaces()	{
		return Response.ok(dataStore.getPlaces()).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{placeId}")
	public Response getPlace(@PathParam("placeId") String placeId) {
		return Response.ok(dataStore.getPlaceById(placeId)).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{placeId}/users")
	public Response getUsersAtPlace(@PathParam("placeId") String placeId) {
		return Response.ok(dataStore.getUsersAtPlace(placeId)).build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createPlace(Place place) {
		if (place == null) {
			return Response.status(400).entity("null object").build();
		}
			
		return Response.ok(dataStore.addPlace(place) ? "new place added" : "place already exists").build();
	}
}
