package com.github.funnygopher.ptu.trainer;

import java.util.ArrayList;
import java.util.List;

import com.github.funnygopher.ptu.Skill;

public class Background {
	private String name, description;
	private List<Skill> patheticSkills;
	private Skill adeptSkill, noviceSkill;

    public Background() {
        name = "";
        description = "";
        patheticSkills = new ArrayList<>();
    }

	public Background(String name, String description, List<Skill> patheticSkills, Skill adeptSkill, Skill noviceSkill) {
		this.name = name;
        this.description = description;
		this.patheticSkills = patheticSkills;
		this.adeptSkill = adeptSkill;
		this.noviceSkill = noviceSkill;
	}

	public String getName() {
		return name;
	}

    public String getDescription() {
        return description;
    }

    public List<Skill> getPatheticSkills() {
		return patheticSkills;
	}

	public Skill getAdeptSkill() {
		return adeptSkill;
	}

	public Skill getNoviceSkill() {
		return noviceSkill;
	}

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPatheticSkills(List<Skill> patheticSkills) {
        this.patheticSkills = patheticSkills;
    }

    public void setAdeptSkill(Skill adeptSkill) {
        this.adeptSkill = adeptSkill;
    }

    public void setNoviceSkill(Skill noviceSkill) {
        this.noviceSkill = noviceSkill;
    }
}
