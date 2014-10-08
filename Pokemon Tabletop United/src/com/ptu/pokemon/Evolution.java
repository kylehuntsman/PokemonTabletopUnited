package com.ptu.pokemon;

public class Evolution {
	private int stage;
	private String speciesName;
	private String evolveCondition;
	
	public Evolution () {
		
	}
	
	public Evolution(int stage, String speciesName, String evolveCondition) {
		this.stage = stage;
		this.speciesName = speciesName;
		this.evolveCondition = evolveCondition;
	}
	
	public int getStage() {
		return stage;
	}
	public String getSpeciesName() {
		return speciesName;
	}
	public String GetEvolveCondition() {
		return evolveCondition;
	}
}
