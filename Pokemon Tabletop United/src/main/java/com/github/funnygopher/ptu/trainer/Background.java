package com.github.funnygopher.ptu.trainer;

import java.util.List;

import com.github.funnygopher.ptu.Skill;

public class Background {
	private String name;
	private String description;
	private List<Skill> increasedSkills;
	private List<Skill> decreasedSkills;
	
	public Background(String name, String description,
			List<Skill> increasedSkills, List<Skill> decreasedSkills) {
		super();
		this.name = name;
		this.description = description;
		this.increasedSkills = increasedSkills;
		this.decreasedSkills = decreasedSkills;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public List<Skill> getIncreasedSkills() {
		return increasedSkills;
	}

	public List<Skill> getDecreasedSkills() {
		return decreasedSkills;
	}
}
