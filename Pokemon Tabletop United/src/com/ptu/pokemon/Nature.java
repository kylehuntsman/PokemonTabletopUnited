package com.ptu.pokemon;

public enum Nature {
	CUDDLY("Cuddly", "HP", "Attack"), DISTRACTED("Distracted", "HP", "Defense"),
	PROUD("Proud", "HP", "Special Atk."), DECISIVE("Decisive", "HP", "Special Def."),
	PATIENT("Patient", "HP", "Speed"), DESPERATE("Desperate", "Attack", "HP"),
	LONELY("Lonely", "Attack", "Defense"), ADAMANT("Adamant", "Attack", "Special Atk."),
	NAUGHTY("Naughty", "Attack", "Special Def."), BRAVE("Brave", "Attack", "Speed"),
	STARK("Stark", "Defense","HP" ),BOLD("Bold", "Defense","Attack" ),
	IMPISH("Impish", "Defense","Special Atk." ), LAX("Lax", "Defense","Special Def." ),
	RELAXED("Relaxed", "Defense","Speed" ), CURIOUS("Curious", "Special Atk.","HP" ),
	MODEST("Modest", "Special Atk.","Attack" ), MILD("Mild", "Special Atk.","Defence" ),
	RASH("Rash", "Special Atk.","Special Atk." ), QUIET("Quiet", "Special Atk.","Special Def." ),
	DREAMY("Dreamy", "Special Def.","HP" ), CALM("Calm", "Special Def.","Attack" ),
	GENTLE("Gentle", "Special Def.","Defence" ), CAREFUL("Careful", "Special Def.","Special Atk." ),
	SASSY("Sassy", "Special Def.","Speed" ), SKITTISH("Skittish", "Speed","HP" ),
	TIMID("Timid", "Speed","Attack" ), HASTY("Hasty", "Speed","Defence" ),
	JOLLY("Jolly", "Speed","Special Atk." ), NAIVE("Naive", "Speed","Special Def." ),
	COMPOSED("Composed", "HP","HP" ), HARDY("Hardy", "Attack","Attack" ),
	DOCILE("Docile", "Defence","Defence" ), BASHFUL("Bashful", "Special Atk.","Special Atk." ),
	QUIRKY("Quirky", "Special Def.","Special Def." ), SERIOUS("Serious", "Speed","Speed" );
	
	private String name;
	private String raisedStat;
	private String loweredStat;
	
	private Nature(String name, String raisedStat, String loweredStat) {
		this.name = name;
		this.raisedStat = raisedStat;
		this.loweredStat = loweredStat;
	}

	public String getLoweredStat() {
		return loweredStat;
	}

	public String getName() {
		return name;
	}

	public String getRaisedStat() {
		return raisedStat;
	}
}