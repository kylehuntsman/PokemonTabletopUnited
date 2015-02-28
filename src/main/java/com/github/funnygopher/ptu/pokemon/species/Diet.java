package com.github.funnygopher.ptu.pokemon.species;

public enum Diet {
	CARNIVORE("Carnivore"),
	HERBIVORE("Herbivore"),
	OMNIVORE("Omnivore"),
	PHOTOTROPH("Phototroph"),
	TERRAVORE("Terravore"),
	NULLIVORE("Nullivore");

	private String name;

	private Diet(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
