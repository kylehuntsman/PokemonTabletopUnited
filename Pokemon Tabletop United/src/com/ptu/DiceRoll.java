package com.ptu;

public class DiceRoll {
	private int numberOfDice;
	private int diceValue;
	private int staticModfier;
	
	public DiceRoll(int numberOfDice, int diceValue, int staticModfier) {
		this.numberOfDice = numberOfDice;
		this.diceValue = diceValue;
		this.staticModfier = staticModfier;
	}

	public int getDiceValue() {
		return diceValue;
	}

	public int getNumberOfDice() {
		return numberOfDice;
	}

	public int getStaticModfier() {
		return staticModfier;
	}
}
