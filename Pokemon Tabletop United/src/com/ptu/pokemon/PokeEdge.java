package com.ptu.pokemon;

import com.ptu.trainer.Edge;

public class PokeEdge extends Edge {
	private int cost;

	public PokeEdge(String name, String prerqs, String effect, int cost) {
		super(name, prerqs, effect);
		this.cost = cost;
	}

	public int getCost() {
		return cost;
	}
}
