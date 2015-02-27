package com.github.funnygopher.ptu.trainer.feature;

import java.util.List;

public class Feature {
	// Refers to page 44 of the PTU Core Handbook
	
	private String name;
	private List<Tag> tags;
	private String prereqs; // This can wait... Lambda Functions???
	private String frequency;
	private String trigger_target; // Can be a trigger or target
	private String effect;
	private String notes;
	
	public Feature() {}

	public String getEffect() {
		return effect;
	}

	public String getFrequency() {
		return frequency;
	}

	public String getName() {
		return name;
	}

	public String getNotes() {
		return notes;
	}

	public String getPrereqs() {
		return prereqs;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public String getTrigger_target() {
		return trigger_target;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public void setPrereqs(String prereqs) {
		this.prereqs = prereqs;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public void setTrigger_target(String trigger_target) {
		this.trigger_target = trigger_target;
	}
}
