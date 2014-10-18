package com.ptu;

//TODO Finish writting the the java doc for frequency enum and re write what a frequency enum is.

/**
 * The <code>Frequency</code> enum represents how often a Feature or Move may
 * be performed and what kind of action is required to perform them.
 */
public enum Frequency {
	AT_WILL("At-Will"), STATIC("Static"), TIME("Time X"), TIME_PER_X("Time/X"), AP(
			"X AP"), BIND_AP("Bind X AP"), DRAIN_AP("Drain X AP");

	private String value;

	Frequency(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
