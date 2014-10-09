package com.ptu;

public enum CombatStat {
	HP("HP"),
	ATTACK("Attack"),
	DEFENSE("Defense"),
	SPECIAL_ATTACK("Special Attack"),
	SPECIAL_DEFENSE("Special Defense"),
	SPEED("Speed");

	private String value;

	private CombatStat(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}
}
