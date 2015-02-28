package com.github.funnygopher.ptu.trainer.equipment;

public enum EquipmentType {
	LARGE_MELEE_WEAPON("Large Melee Weapon"),
	SMALL_MELEE_WEAPON("Small Melee Weapon"),
	LONG_RANGED_WEAPON("Long Ranged Weapon"),
	SHORT_RANGED_WEAPON("Short Ranged Weapon"),
	NONE("None"),
	IMPROMPTU("Impromptu");
	
	private String name;
	
	private EquipmentType(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
