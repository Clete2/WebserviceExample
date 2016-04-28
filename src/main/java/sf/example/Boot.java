package sf.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
/**
 * Main class to start the application. Runs an embedded Tomcat server.
 */
public class Boot {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Boot.class, args);
	}
}
