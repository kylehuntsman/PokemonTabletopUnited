package com.github.funnygopher.ptu.pokemon;

public enum Size {
	SMALL("Small"),
	MEDIUM("Medium"),
	LARGE("Large"),
	HUGE("Huge"),
	GIGANTIC("Gigantic");

	private String name;

	private Size(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
