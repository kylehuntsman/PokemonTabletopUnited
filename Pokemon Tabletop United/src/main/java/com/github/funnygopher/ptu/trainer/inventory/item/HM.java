package com.github.funnygopher.ptu.trainer.inventory.item;

import com.github.funnygopher.ptu.move.Move;

public class HM extends Item {
	
	private String code;
	private Move move;
	
	public HM(String code, Move move, int cost, int quantity) {
		super(code + " - " + move.getName(), move.getEffect(), cost, quantity);
		this.code = code;
		this.move = move;
	}
	
	public String getCode() {
		return code;
	}
	
	public Move getMove() {
		return move;
	}
}
