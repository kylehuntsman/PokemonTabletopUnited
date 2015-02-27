package com.github.funnygopher.ptu.trainer;

public enum Attribute {

	TERRIBLE(-2),
	POOR(-1),
	AVERAGE(0),
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

	public static Attribute getAttribute(int value) {
		Attribute attribute = null;

		switch (value) {
		case -2:
			attribute = TERRIBLE;
			break;
		case -1:
			attribute = POOR;
			break;
		case 0:
			attribute = AVERAGE;
			break;
		case 1:
			attribute = FAIR;
			break;
		case 2:
			attribute = GOOD;
			break;
		case 3:
			attribute = GREAT;
			break;
		case 4:
			attribute = SUPERB;
			break;
		case 5:
			attribute = FABULOUS;
			break;
		case 6:
			attribute = AMAZING;
			break;
		}

		return attribute;
	}
}
