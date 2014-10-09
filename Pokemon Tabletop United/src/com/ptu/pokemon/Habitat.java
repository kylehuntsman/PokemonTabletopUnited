package com.ptu.pokemon;

public enum Habitat {
	GRASSLAND("Grassland"),
	FOREST("Forest"),
	MARSH("Marsh"),
	OCEAN("Ocean"),
	BEACH("Beach"),
	FREASHWATER("Freashwater"),
	TUNDRA("Tundra"),
	TAIGA("Taiga"),
	MOUNTAIN("Mountain"),
	CAVE("Cave"),
	URBAN("Urban"),
	DESERT("Desert"),
	RAINFOREST("Rain Forest");

	private String value;

	private Habitat(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
}
