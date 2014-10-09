package com.ptu.pokemon;

public enum EggGroup {
	FLYING("Flying"),
	BUG("Bug"),
	MONSTER("Monster"),
	WATER1("Water 1"),
	WATER2("Water 2"),
	WATER3("Water 3"),
	FIELD("Field"),
	FAIRY("Fairy"),
	PLANT("Plant"),
	MINERAL("Mineral"),
	HUMANSHAPE("Humanshape"),
	DITTO("Ditto"),
	DRAGON("Dragon"),
	INDETERMINATE("Indeterminate");

	private String name;

	private EggGroup(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
