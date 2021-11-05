//This class communicates with the front-end 
//Endpoints
//Receives requests, and sends responses

package com.example.demo.mushrooms.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mushrooms.domain.Mushroom;

//The following annotation is used to build REST API in a declarative way 
//Basically it enables request handling
//Spring RestController takes care of mapping request data to the defined request handler method. 
//Once response body is generated from the handler method, it converts it to JSON response.
@RestController
public class MushroomController {
		
		// PURELY FOR DEMO PURPOSES
		private List<Mushroom> mushrooms = new ArrayList<>(); // explain this tomorrow

		@GetMapping("/hello") // listen for a request at /hello
		public String hello() {
			return "Hello, World!"; // sends response
		}

		@PostMapping("/create") // triggered by a POST request to /create
		public ResponseEntity<Mushroom> createMushroom(@RequestBody Mushroom newMushroom) { // a Mushroom object in the request + response
																				// body
			this.mushrooms.add(newMushroom);
			Mushroom responseBody = this.mushrooms.get(this.mushrooms.size() - 1);
			return new ResponseEntity<Mushroom>(responseBody, HttpStatus.CREATED);
		}

		@GetMapping("/getAll")
		public ResponseEntity<List<Mushroom>> getMushrooms() {
			return ResponseEntity.ok(this.mushrooms); // unnecessary due to default being 200 anyway
		}

		@GetMapping("/get/{id}") // getMushroom with id of {id}
		public Mushroom getMushroom(@PathVariable Integer id) {
			return this.mushrooms.get(id);
		}

		@PutMapping("/replace/{id}")
		public ResponseEntity<Mushroom> replaceMushroom(@PathVariable Integer id, @RequestBody Mushroom newMushroom) {

			System.out.println("Replacing Mushroom with id " + id + " with " + newMushroom);
			return null;
		}

		@DeleteMapping("/remove/{id}")
		public ResponseEntity<?> removeMushroom(@PathVariable Integer id) {
			System.out.println("Removing Mushroom with id " + id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
