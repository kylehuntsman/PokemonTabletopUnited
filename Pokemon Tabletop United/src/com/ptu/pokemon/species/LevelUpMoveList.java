package com.ptu.pokemon.species;

import java.util.HashMap;
import java.util.Map;

import com.ptu.move.Move;

public class LevelUpMoveList {
	
	private Map<Integer, Move> moves;
	
	public LevelUpMoveList(HashMap<Integer, Move> moves) {
		this.moves = moves;
	}
	
	public boolean contains(int level) {
		return moves.containsKey(level);
	}
	
	public Move getMove(int level) {
		return moves.get(level);
	}
}
