package com.ptu.trainer;

public enum Attribute {

	TERRIBLE(-2),
	POOR(-1),
	AVERAGE( 0),
	FAIR(1),
	GOOD(2),
	GREAT(3),
	SUPERB(4),
	FABULOUS(5),
	AMAZING(6);

	private int value;

	/**
	 * Instantiates an Attribute with an integer value
	 * 
	 * @param value
	 *            - The integer value of the attribute
	 */
	private Attribute(int value) {
		this.value = value;
	}

	/**
	 * Gets the integer value of the attribute
	 * 
	 * @return The integer value of the attribute
	 */
	public int getValue() {
		return value;
	}
	
	public String toString() {
		return this.toString().substring(0, 1).toUpperCase() + this.toString().substring(1).toLowerCase();
	}

}
