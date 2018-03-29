package start.project1;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.StatusType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/users")
public class UserController {

	@Autowired
	private DataStore dataStore;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listUsers()
	{
		return Response.ok(dataStore.getUsers()).build();
	}
	
	@GET
	@Path("{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserInfo(@PathParam("userId") String name)
	{
		User desiredUser = dataStore.getUserById(name);
		if (desiredUser != null)
			return Response.ok(desiredUser).build();

		return Response.status(404).entity("no such user").build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addUser(User newUser) {
		if (newUser == null) return Response.status(400).entity("user was null").build();
		if (newUser.getId() == null || newUser.getName() == null) 
			return Response.status(400).entity("id and name cannot be null").build();
		
		dataStore.addUser(newUser);
		return Response.ok("user added").build();
	}
	
	@PUT
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateUser(UserUpdate updateInfo) {
		
		User desiredUser = dataStore.getUserById(updateInfo.getUserId());
		if (desiredUser == null) {
			return Response.status(404).entity("no such user").build();
		}
		
		Place newPlace = dataStore.getPlaceById(updateInfo.getPlaceId());
		if (newPlace != null) {
			desiredUser.addPlace(newPlace);
			return Response.ok("user updated").build();
		}
		return Response.status(404).entity("no such place").build();
	}
}
