package com.ptu.pokemon.species;

public enum Habitat {
	ARCTIC("Arctic"),
	GRASSLAND("Grassland"),
	FOREST("Forest"),
	MARSH("Marsh"),
	OCEAN("Ocean"),
	BEACH("Beach"),
	FRESHWATER("Freshwater"),
	TUNDRA("Tundra"),
	TAIGA("Taiga"),
	MOUNTAIN("Mountain"),
	CAVE("Cave"),
	URBAN("Urban"),
	DESERT("Desert"),
	RAINFOREST("Rain Forest");

	private String name;

	private Habitat(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
