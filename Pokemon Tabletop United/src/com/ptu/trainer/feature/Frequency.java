package com.ptu.trainer.feature;

public enum Frequency {
	AT_WILL("At-Will"),
	STATIC("Static"),
	TIME("Time X"),
	TIME_PER_X("Time/X"),
	AP("X AP"),
	BIND_AP("Bind X AP"),
	DRAIN_AP("Drain X AP");

	private String value;

	Frequency(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
