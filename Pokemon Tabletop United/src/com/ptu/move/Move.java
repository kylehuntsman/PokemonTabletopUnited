package com.ptu.move;

import com.ptu.Frequency;
import com.ptu.move.contest.ContestEffect;
import com.ptu.move.contest.ContestStat;
import com.ptu.pokemon.species.Type;

public class Move {
	private String name;
	private Type type;
	private Frequency frequency;
	private int accuracyCheck;
	private int damageBaseValue;
	private String calculatedDamage;
	private int quickDamage;
	private MoveClass moveClass;
	private String range;
	private String effect;
	private ContestStat contestStat;
	private ContestEffect contestEffect;
	
	public Move(String name, Type type, Frequency frequency, int accuracyCheck,
			int damageBaseValue, String calculatedDamage, int quickDamage,
			MoveClass moveClass, String range, String effect,
			ContestStat contestStat, String contestEffect) {
		this.name = name;
		this.type = type;
		this.frequency = frequency;
		this.accuracyCheck = accuracyCheck;
		this.damageBaseValue = damageBaseValue;
		this.calculatedDamage = calculatedDamage;
		this.quickDamage = quickDamage;
		this.moveClass = moveClass;
		this.range = range;
		this.effect = effect;
		this.contestStat = contestStat;
		this.contestEffect = contestEffect;
	}
	public int getAccuracyCheck() {
		return accuracyCheck;
	}
	public String getCalculatedDamage() {
		return calculatedDamage;
	}
	public String getContestEffect() {
		return contestEffect;
	}
	public ContestStat getcontestStat() {
		return contestStat;
	}
	public int getDamageBaseValue() {
		return damageBaseValue;
	}
	public String getEffect() {
		return effect;
	}
	public Frequency getFrequency() {
		return frequency;
	}
	public MoveClass getMoveClass() {
		return moveClass;
	}
	public String getName() {
		return name;
	}
	public int getQuickDamage() {
		return quickDamage;
	}
	public String getRange() {
		return range;
	}
	public Type getType() {
		return type;
	}
}
