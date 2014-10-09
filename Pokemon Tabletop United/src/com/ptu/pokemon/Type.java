package com.ptu.pokemon;

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
	FAIRY("Fairy");

	private String value;

	private Type(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}
}
