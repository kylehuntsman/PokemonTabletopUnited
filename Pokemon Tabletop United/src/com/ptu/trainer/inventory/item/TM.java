package com.ptu.trainer.inventory.item;

import com.ptu.move.Move;

public class TM extends Item {
	
	private String code;
	private Move move;
	
	public TM(String code, Move move, int cost, int quantity) {
		super(code + " - " + move.getName(), move.getEffect(), cost, quantity);
		this.move = move;
	}
	
	public String getCode() {
		return code;
	}
	
	public Move getMove() {
		return move;
	}
}
