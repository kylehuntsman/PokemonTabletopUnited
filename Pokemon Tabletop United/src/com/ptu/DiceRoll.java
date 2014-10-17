package com.ptu;

/**
 * The <code>DiceRoll</code> class represents dice roll.
 */
public class DiceRoll {
	private int numberOfDice;
	private int diceValue;
	private int staticModifier;

	/**
	 * Instantiates an <code>Ability</code> object.
	 * 
	 * @param numberOfDice
	 *            - The number of dice being used.
	 * @param diceValue
	 *            - The number of sides on the dice.
	 * @param staticModifier
	 *            - The value added to the dice roll.
	 */
	public DiceRoll(int numberOfDice, int diceValue, int staticModfier) {
		this.numberOfDice = numberOfDice;
		this.diceValue = diceValue;
		this.staticModifier = staticModfier;
	}

	/**
	 * Gets the dice value
	 * 
	 * @return dice value
	 */
	public int getDiceValue() {
		return diceValue;
	}

	/**
	 * Gets the number of dice
	 * 
	 * @return number of dice
	 */
	public int getNumberOfDice() {
		return numberOfDice;
	}

	/**
	 * Gets the static modifier
	 * 
	 * @return static modifier
	 */
	public int getStaticModifier() {
		return staticModifier;
	}
}
