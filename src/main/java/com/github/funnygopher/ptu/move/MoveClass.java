package com.github.funnygopher.ptu.move;

public enum MoveClass {
	STATUS("Status"), SPECIAL("Special"), PHYSICAL("Physical"), STATIC("Static"), ERROR("Error"), NONE("None");
	
	private String name;

	private MoveClass(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
