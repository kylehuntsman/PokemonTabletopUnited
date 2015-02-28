package com.github.funnygopher.ptu.move.contest;

public class ContestEffect {
	private String name;
	private String dice;
	private String effect;
	
	public ContestEffect(String name, String dice, String effect) {
		this.name = name;
		this.dice = dice;
		this.effect = effect;
	}
	
	public String getDice() {
		return dice;
	}
	public String getEffect() {
		return effect;
	}
	public String getName() {
		return name;
	}	
}
