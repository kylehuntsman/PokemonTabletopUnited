package com.ptu.move.contest;

public enum ContestStat {
	BEAUTY("Beuaty"), COOL("Cool"), CUTE("Cute"),
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
