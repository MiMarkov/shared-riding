package start.project1;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

@Component
@Path("/hello")
public class Greeter {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response sayHello()
	{
		Response r = Response.ok("hi response").build();
		return r;
	}
	
	@GET
	@Path("time")
	@Produces(MediaType.APPLICATION_JSON)
	public TimeData getTime() {
		return new TimeData();
	}
}
