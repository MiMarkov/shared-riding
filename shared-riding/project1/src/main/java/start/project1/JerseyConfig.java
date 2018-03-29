package start.project1;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(Greeter.class);
		register(UserController.class);
		register(PlacesController.class);
	}

}
