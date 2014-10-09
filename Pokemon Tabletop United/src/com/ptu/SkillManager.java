package com.ptu;

public class SkillManager {
	
	private Skill acrobatics, athletics, combat, intimidate;
	private Skill stealth, survival;
	private Skill generalEdu, medicineEdu, occultEdu, technologyEdu;
	private Skill guile, perception;
	private Skill charm, command, focus, intuition;
	
	public SkillManager() {
		acrobatics = athletics = combat = intimidate = Skill.UNTRAINED;
		stealth = survival = Skill.UNTRAINED;
		generalEdu = medicineEdu = occultEdu = technologyEdu = Skill.UNTRAINED;
		guile = perception = Skill.UNTRAINED;
		charm = command = focus = intuition = Skill.UNTRAINED;
	}
	
	public Skill getAcrobatics() {
		return acrobatics;
	}

	public Skill getAthletics() {
		return athletics;
	}

	public Skill getCharm() {
		return charm;
	}

	public Skill getCombat() {
		return combat;
	}

	public Skill getCommand() {
		return command;
	}

	public Skill getFocus() {
		return focus;
	}

	public Skill getGeneralEdu() {
		return generalEdu;
	}

	public Skill getGuile() {
		return guile;
	}

	public Skill getIntimidate() {
		return intimidate;
	}

	public Skill getMedicineEdu() {
		return medicineEdu;
	}

	public Skill getOccultEdu() {
		return occultEdu;
	}

	public Skill getPerception() {
		return perception;
	}

	public Skill getStealth() {
		return stealth;
	}

	public Skill getSurvival() {
		return survival;
	}

	public Skill getTechnologyEdu() {
		return technologyEdu;
	}

	public void setAcrobatics(Skill acrobatics) {
		this.acrobatics = acrobatics;
	}

	public void setAthletics(Skill athletics) {
		this.athletics = athletics;
	}

	public void setCharm(Skill charm) {
		this.charm = charm;
	}

	public void setCombat(Skill combat) {
		this.combat = combat;
	}

	public void setCommand(Skill command) {
		this.command = command;
	}

	public void setFocus(Skill focus) {
		this.focus = focus;
	}

	public void setGeneralEdu(Skill generalEdu) {
		this.generalEdu = generalEdu;
	}

	public void setGuile(Skill guile) {
		this.guile = guile;
	}

	public void setIntimidate(Skill intimidate) {
		this.intimidate = intimidate;
	}

	public void setMedicineEdu(Skill medicineEdu) {
		this.medicineEdu = medicineEdu;
	}

	public void setOccultEdu(Skill occultEdu) {
		this.occultEdu = occultEdu;
	}

	public void setPerception(Skill perception) {
		this.perception = perception;
	}

	public void setStealth(Skill stealth) {
		this.stealth = stealth;
	}

	public void setSurvival(Skill survival) {
		this.survival = survival;
	}

	public void setTechnologyEdu(Skill technologyEdu) {
		this.technologyEdu = technologyEdu;
	}
}
