package ba.edu.ibu.CookingApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
//@CrossOrigin(origins = "*")
public class CookingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CookingAppApplication.class, args);
	}

}
