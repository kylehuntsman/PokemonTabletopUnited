package com.ptu.trainer;

public enum Skill {
	PATHETIC(1, 1),
	UNTRAINED(2, 1),
	NOVICE(3, 1),
	ADEPT(4, 2),
	EXPERT(5, 6),
	MASTER(6, 12);

	private int value;
	private int levelPreReq;

	private Skill(int value, int levelPreReq) {
		this.value = value;
	}

	public int getLevelPreReq() {
		return levelPreReq;
	}

	public int getValue() {
		return value;
	}
}
