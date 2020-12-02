package ie.cct.farmCA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

// Main class of the application;
// Responsible for running the application;

// SpringBootsAplication configures the application as an SpringBoot document;
@SpringBootApplication
@ComponentScan("ie.cct.*")
public class FarmCaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FarmCaApplication.class, args);
	}

}
