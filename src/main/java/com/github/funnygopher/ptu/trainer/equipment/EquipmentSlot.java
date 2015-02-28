package com.github.funnygopher.ptu.trainer.equipment;

public enum EquipmentSlot {
	HEAD("Head"),
	MAIN_HAND("Main Hand"),
	OFF_HAND("Off Hand"),
	TWO_HANDED("Two Handed"),
	BODY("Body"),
	FEET("Feet"),
	ACCESSORY("Accessory");
	
	private String name;
	
	private EquipmentSlot(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
