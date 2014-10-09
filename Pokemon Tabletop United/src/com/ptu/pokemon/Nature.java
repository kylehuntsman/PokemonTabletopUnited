package com.ptu.pokemon;

import com.ptu.CombatStat;

public enum Nature {
	CUDDLY("Cuddly", CombatStat.HP, CombatStat.ATTACK), DISTRACTED("Distracted", CombatStat.HP, CombatStat.DEFENSE),
	PROUD("Proud", CombatStat.HP, CombatStat.SPECIAL_ATTACK), DECISIVE("Decisive", CombatStat.HP, CombatStat.SPECIAL_DEFENSE),
	PATIENT("Patient", CombatStat.HP, CombatStat.SPEED), DESPERATE("Desperate", CombatStat.ATTACK, CombatStat.HP),
	LONELY("Lonely", CombatStat.ATTACK, CombatStat.DEFENSE), ADAMANT("Adamant", CombatStat.ATTACK, CombatStat.SPECIAL_ATTACK),
	NAUGHTY("Naughty", CombatStat.ATTACK, CombatStat.SPECIAL_DEFENSE), BRAVE("Brave", CombatStat.ATTACK, CombatStat.SPEED),
	STARK("Stark", CombatStat.DEFENSE,CombatStat.HP ),BOLD("Bold", CombatStat.DEFENSE,CombatStat.ATTACK ),
	IMPISH("Impish", CombatStat.DEFENSE,CombatStat.SPECIAL_ATTACK ), LAX("Lax", CombatStat.DEFENSE,CombatStat.SPECIAL_DEFENSE ),
	RELAXED("Relaxed", CombatStat.DEFENSE,CombatStat.SPEED ), CURIOUS("Curious", CombatStat.SPECIAL_ATTACK,CombatStat.HP ),
	MODEST("Modest", CombatStat.SPECIAL_ATTACK,CombatStat.ATTACK ), MILD("Mild", CombatStat.SPECIAL_ATTACK,CombatStat.DEFENSE ),
	RASH("Rash", CombatStat.SPECIAL_ATTACK,CombatStat.SPECIAL_ATTACK ), QUIET("Quiet", CombatStat.SPECIAL_ATTACK,CombatStat.SPECIAL_DEFENSE ),
	DREAMY("Dreamy", CombatStat.SPECIAL_DEFENSE,CombatStat.HP ), CALM("Calm", CombatStat.SPECIAL_DEFENSE,CombatStat.ATTACK ),
	GENTLE("Gentle", CombatStat.SPECIAL_DEFENSE,CombatStat.DEFENSE ), CAREFUL("Careful", CombatStat.SPECIAL_DEFENSE,CombatStat.SPECIAL_ATTACK ),
	SASSY("Sassy", CombatStat.SPECIAL_DEFENSE,CombatStat.SPEED ), SKITTISH("Skittish", CombatStat.SPEED,CombatStat.HP ),
	TIMID("Timid", CombatStat.SPEED,CombatStat.ATTACK ), HASTY("Hasty", CombatStat.SPEED,CombatStat.DEFENSE ),
	JOLLY("Jolly", CombatStat.SPEED,CombatStat.SPECIAL_ATTACK ), NAIVE("Naive", CombatStat.SPEED,CombatStat.SPECIAL_DEFENSE ),
	COMPOSED("Composed", CombatStat.HP,CombatStat.HP ), HARDY("Hardy", CombatStat.ATTACK,CombatStat.ATTACK ),
	DOCILE("Docile", CombatStat.DEFENSE,CombatStat.DEFENSE ), BASHFUL("Bashful", CombatStat.SPECIAL_ATTACK,CombatStat.SPECIAL_ATTACK ),
	QUIRKY("Quirky", CombatStat.SPECIAL_DEFENSE,CombatStat.SPECIAL_DEFENSE ), SERIOUS("Serious", CombatStat.SPEED,CombatStat.SPEED );
	
	private String name;
	private CombatStat raisedStat;
	private CombatStat loweredStat;
	
	private Nature(String name, CombatStat raisedStat, CombatStat loweredStat) {
		this.name = name;
		this.raisedStat = raisedStat;
		this.loweredStat = loweredStat;
	}

	public CombatStat getLoweredStat() {
		return loweredStat;
	}

	public String getName() {
		return name;
	}

	public CombatStat getRaisedStat() {
		return raisedStat;
	}
}