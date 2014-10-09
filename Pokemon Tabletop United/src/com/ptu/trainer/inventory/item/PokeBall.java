package com.ptu.trainer.inventory.item;

public class PokeBall extends Item {

	private int ballNumber;
	private int modifier;
	
	public PokeBall(int ballNumber, String name, int modifier, String special, int cost, int quantity) {
		super(name, special, cost, quantity);
		this.ballNumber = ballNumber;
		this.modifier = modifier;
	}

	public int getBallNumber() {
		return ballNumber;
	}

	public int getModifier() {
		return modifier;
	}

	public void setBallNumber(int ballNumber) {
		this.ballNumber = ballNumber;
	}

	public void setModifier(int modifier) {
		this.modifier = modifier;
	}
}
