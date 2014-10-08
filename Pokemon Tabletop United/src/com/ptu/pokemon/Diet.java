package com.ptu.pokemon;

public enum Diet {
	CARNIVORE("Carnivore"), HERBIVORE("Herbivore"), OMNIVORE("Omnivore"), 
	PHOTOTROPH("Phototroph"), TERRAVORE("Terravore"), NULLIVORE("Nullivore");
	
	private String value;
	
	private Diet(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
