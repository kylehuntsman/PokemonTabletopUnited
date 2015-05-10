package com.github.funnygopher.ptu.move;

import com.github.funnygopher.ptu.Frequency;
import com.github.funnygopher.ptu.move.contest.ContestStat;
import com.github.funnygopher.ptu.pokemon.species.Type;
import com.github.funnygopher.ptu.move.contest.ContestEffect;

public class Move {
	private String name;
	private Type type;
	private String frequency;
	private int accuracyCheck;
	private int damageBaseValue;
	private MoveClass moveClass;
	private String range;
	private String effect;
	private ContestStat contestStat;
	private ContestEffect contestEffect;
    private String special;
	
	public Move(String name, Type type, String frequency, int accuracyCheck,
			int damageBaseValue, MoveClass moveClass, String range, String effect,
			ContestStat contestStat, ContestEffect contestEffect, String special) {
		this.name = name;
		this.type = type;
		this.frequency = frequency;
		this.accuracyCheck = accuracyCheck;
		this.damageBaseValue = damageBaseValue;
        this.moveClass = moveClass;
		this.range = range;
		this.effect = effect;
		this.contestStat = contestStat;
		this.contestEffect = contestEffect;
        this.special = special;
	}
	public int getAccuracyCheck() {
		return accuracyCheck;
	}
	public ContestEffect getContestEffect() {
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
	public String getFrequency() {
		return frequency;
	}
	public MoveClass getMoveClass() {
		return moveClass;
	}
	public String getName() {
		return name;
	}
	public String getRange() {
		return range;
	}
	public Type getType() {
		return type;
	}

    @Override public String toString() {
        String result = "";
        result += "Name: " + name + "\n";
        result += "Type: " + type.toString() + "\n";
        result += "Frequency: " + frequency + "\n";
        result += "Accuracy Check: " + accuracyCheck + "\n";
        result += "Damage Base Value: " + damageBaseValue + "\n";
        if (moveClass != null)
            result += "Move Class: " + moveClass.toString() + "\n";
        result += "Range: " + range + "\n";
        result += "Effect: " + effect + "\n";
        result += "Contest Stat: " + contestStat.toString() + "\n";
        result += "Contest Effect: " + contestEffect.getName() + "\n";
        result += "Special: " + special;
        return  result;
    }
}
