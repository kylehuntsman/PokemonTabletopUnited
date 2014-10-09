package com.ptu.pokemon;

public enum Size {
	SMALL("Small"), MEDIUM("Medium"), LARGE("Large"), 
	HUGE("Huge"), GIGANTIC("Gigantic");
	
	private String value;
	
	private Size(String value) {
		this.value = value;
	}
}
