package com.ptu.trainer;

public class Edge {
	
	private String name;
	private String prereqs; // Lambda function???
	private String effect;
	
	public Edge(String name, String prereqs, String effect) {
		this.name = name;
		this.prereqs = prereqs;
		this.effect = effect;
	}

	public String getEffect() {
		return effect;
	}

	public String getName() {
		return name;
	}

	public String getPrereqs() {
		return prereqs;
	}
}
