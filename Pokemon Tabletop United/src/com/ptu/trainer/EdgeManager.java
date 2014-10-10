package com.ptu.trainer;

import java.util.ArrayList;
import java.util.List;

public class EdgeManager {
	
	private List<Edge> edges;
	
	public EdgeManager() {
		edges = new ArrayList<Edge>();
	}
	
	public void add(Edge edge) {
		edges.add(edge);
	}
	
	public boolean contains(Edge edge) {
		return edges.contains(edge);
	}
	
	public Edge get(int index) {
		return edges.get(index);
	}
	
	public void remove(Edge edge) {
		edges.remove(edge);
	}
}
