package com.ptu.move;

import java.util.ArrayList;
import java.util.List;

public class MoveManager {
	
	private List<Move> moves;
	
	public MoveManager() {
		moves = new ArrayList<Move>();
	}
	
	public void add(Move move) {
		moves.add(move);
	}
	
	public boolean contains(Move move) {
		return moves.contains(move);
	}
	
	public void remove(Move move) {
		moves.remove(move);
	}
}
