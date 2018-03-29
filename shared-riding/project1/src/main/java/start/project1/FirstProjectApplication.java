package start.project1;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class FirstProjectApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		new FirstProjectApplication()
				.configure(new SpringApplicationBuilder(FirstProjectApplication.class))
				.run(args);
	}

}