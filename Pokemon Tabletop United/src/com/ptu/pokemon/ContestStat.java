package com.ptu.pokemon;

public enum ContestStat {
	BEAUTY("Beauty"), COOL("Cool"), CUTE("Cute"),
	SMART("Smart"), TOUGH("Tough");
	
	private String name;

	private ContestStat(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
