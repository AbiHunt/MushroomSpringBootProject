//This class is an entity
//It needs getters/setters, and default constructor
//Also needs the primary key/Id 

package com.example.demo.mushrooms.domain;

import javax.persistence.Entity;

@Entity 
public class Mushroom {
	
	private String name;

	private String species;

	private int height;

	public Mushroom(String name, String species, int height) {
		super();
		this.name = name;
		this.species = species;
		this.setHeight(height);
	}

	public Mushroom() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecies() {
		return species;
	}

	public void setBreed(String species) {
		this.species = species;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		if (height > 8 && height < 100) {
			this.height = height;
		} else {
			System.out.println("Invalid height: " + height);
		}
	}

	@Override
	public String toString() {
		return "Mushroom [name=" + name + ", species=" + species + ", height=" + height + "]";
	}

}
 