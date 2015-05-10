package com.github.funnygopher.ptu.move.contest;

public enum ContestStat {
	BEAUTY("Beauty"), COOL("Cool"), CUTE("Cute"),
	SMART("Smart"), TOUGH("Tough"), ERROR("Error");
	
	private String name;
	
	private ContestStat(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
