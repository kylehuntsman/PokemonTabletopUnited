package com.ptu.trainer;

public class Edge {
	
	private String name;
	private String prerqs; //TODO Look up Lambda Functions
	private String effect;
	public Edge(String name, String prerqs, String effect) {
		super();
		this.name = name;
		this.prerqs = prerqs;
		this.effect = effect;
	}
	
	public String getEffect() {
		return effect;
	}
	public String getName() {
		return name;
	}
	public String getPrerqs() {
		return prerqs;
	}
}
