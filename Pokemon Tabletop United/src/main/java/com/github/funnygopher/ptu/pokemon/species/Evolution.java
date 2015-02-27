package com.github.funnygopher.ptu.pokemon.species;

public class Evolution {
	private int stage;
	private String speciesName;
	private String evolveCondition;
	
	public Evolution(int stage, String speciesName, String evolveCondition) {
		this.stage = stage;
		this.speciesName = speciesName;
		this.evolveCondition = evolveCondition;
	}
	
	public String getEvolveCondition() {
		return evolveCondition;
	}
	public String getSpeciesName() {
		return speciesName;
	}
	public int getStage() {
		return stage;
	}
}
