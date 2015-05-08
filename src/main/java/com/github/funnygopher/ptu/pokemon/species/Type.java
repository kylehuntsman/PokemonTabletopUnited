package com.github.funnygopher.ptu.pokemon.species;

public enum Type {
	NORMAL("Normal"),
	FIGHTING("Fighting"),
	FLYING("Flying"),
	POISON("Poison"),
	GROUND("Ground"),
	ROCK("Rock"),
	BUG("Bug"),
	GHOST("Ghost"),
	STEEL("Steel"),
	FIRE("Fire"),
	WATER("Water"),
	GRASS("Grass"),
	ELECTRIC("Electric"),
	PSYCHIC("Psychic"),
	ICE("Ice"),
	DRAGON("Dragon"),
	DARK("Dark"),
	FAIRY("Fairy"),
    NONE("None");

	private String name;

	private Type(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
