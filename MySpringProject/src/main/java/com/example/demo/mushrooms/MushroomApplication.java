//This is my main method!

package com.example.demo.mushrooms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.mushrooms.domain.Mushroom;
import com.example.demo.mushrooms.rest.MushroomController;
import com.fasterxml.jackson.databind.ObjectMapper;


//The following annotation enables spring boot and the component scan
@SpringBootApplication
public class MushroomApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(MushroomApplication.class, args);

		ObjectMapper mapper = new ObjectMapper();

		Mushroom demoMushroom = new Mushroom("Toadstool", "Amanita", 12);

		String demoMushroomAsJSON = mapper.writeValueAsString(demoMushroom);

		System.out.println(demoMushroomAsJSON);

		Mushroom backToMushroom = mapper.readValue(demoMushroomAsJSON, Mushroom.class);

		System.out.println(backToMushroom);

		// SUPER DEMO PURPOSES
		MushroomServiceDB service = new MushroomServiceDB();

		MushroomController controller = new MushroomController(service);
		
	}
}
