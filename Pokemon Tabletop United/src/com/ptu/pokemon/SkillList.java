package com.ptu.pokemon;

public class SkillList {
	private String athletics, acrobatics, combat, stealth, perception, focus;

	public SkillList() {
		
	}
	
	public SkillList(String athletics, String acrobatics, String combat,
			String stealth, String perception, String focus) {
		this.athletics = athletics;
		this.acrobatics = acrobatics;
		this.combat = combat;
		this.stealth = stealth;
		this.perception = perception;
		this.focus = focus;
	}

	public String getAthletics() {
		return athletics;
	}

	public String getAcrobatics() {
		return acrobatics;
	}

	public String getCombat() {
		return combat;
	}

	public String getStealth() {
		return stealth;
	}

	public String getPerception() {
		return perception;
	}

	public String getFocus() {
		return focus;
	}
	
	
}
