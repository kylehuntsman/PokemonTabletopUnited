package com.ptu;
import com.ptu.trainer.feature.Frequency;

public class Ability {
	private String name;
	private Frequency frequency;
	private String target;
	private String trigger;
	private String effect;
	
	public Ability(String name, Frequency frequency, String target,
			String trigger, String effect) {
		this.name = name;
		this.frequency = frequency;
		this.target = target;
		this.trigger = trigger;
		this.effect = effect;
	}

	public String getName() {
		return name;
	}
	public Frequency getFrequency() {
		return frequency;
	}
	public String getTarget() {
		return target;
	}
	public String getTrigger() {
		return trigger;
	}
	public String getEffect() {
		return effect;
	}
}
