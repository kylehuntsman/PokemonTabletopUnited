package com.ptu.pokemon;

public class Capability {
	private String name;
	private String description;
	
	public Capability(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}
}
