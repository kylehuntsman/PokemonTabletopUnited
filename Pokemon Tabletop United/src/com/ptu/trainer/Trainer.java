package com.ptu.trainer;

import com.ptu.CombatStats;
import com.ptu.trainer.feature.FeatureManager;

public class Trainer {
	
	/**
	 * Trainer information
	 */
	private String name, gender, background, size, description;
	private int age, weight;
	
	/**
	 * Attributes
	 */
	private Attribute body, mind, spirit;
	
	/**
	 * Stats
	 */
	private SkillManager skills;
	private CombatStats combatStats;
	private int level, exp, actionPoints, hitPoints, injuries;
	private String abilities;
	
	private FeatureManager features;
	
	/**
	 * Instantiates a Trainer object
	 */
	public Trainer() {
		initAttributes();
		skills = new SkillManager();
		setCombatStats(new CombatStats(10, 5, 5, 5, 5, 5));
		level = 1;
		setFeatures(new FeatureManager());
	}
	
	public int getActionPoints() {
		return actionPoints;
	}

	public int getAge() {
		return age;
	}

	public String getBackground() {
		return background;
	}

	public Attribute getBody() {
		return body;
	}
	
	public CombatStats getCombatStats() {
		return combatStats;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getExp() {
		return exp;
	}
	
	public FeatureManager getFeatures() {
		return features;
	}
	
	public String getGender() {
		return gender;
	}
	
	public int getHighJump(boolean isRunning) {
		int highJump = 0;
		
		if(skills.getAcrobatics().compareTo(Skill.ADEPT) >= 0)
			highJump++;
		if(skills.getAcrobatics().compareTo(Skill.MASTER) >= 0)
			highJump++;
		if(isRunning)
			highJump++;
		
		return highJump;
	}

	public int getHitPoints() {
		return hitPoints;
	}

	public int getInjuries() {
		return injuries;
	}

	public int getLongJump() {
		return skills.getAcrobatics().getValue() / 2;
	}	

	public int getMaxHitPoints() {
		return (level * 2) + (combatStats.getHP() * 3) + 10;
	}

	public Attribute getMind() {
		return mind;
	}

	public String getName() {
		return name;
	}

	public int getOverland() {
		return 3 + ((skills.getAcrobatics().getValue() + skills.getAthletics().getValue()) / 2);
	}

	public int getPower() {
		int power = 4;
		
		if(body.compareTo(Attribute.AVERAGE) < 0 | skills.getAthletics().equals(Skill.PATHETIC))
			power--;
		if(body.compareTo(Attribute.GOOD) >= 0)
			power++;
		if(body.compareTo(Attribute.FABULOUS) >= 0)
			power++;
		if(skills.getAthletics().compareTo(Skill.NOVICE) >= 0)
			power++;
		if(skills.getCombat().compareTo(Skill.ADEPT) >= 0)
			power++;
		
		return power;
	}

	public String getSize() {
		return size;
	}

	public Attribute getSpirit() {
		return spirit;
	}

	public int getSwimming() {
		return getOverland() / 2;
	}

	public int getThrowingRange() {
		return 4 + skills.getAthletics().getValue();
	}

	public int getWeight() {
		return weight;
	}

	private void initAttributes() {
		setBody(Attribute.AVERAGE);
		setMind(Attribute.AVERAGE);;
		setSpirit(Attribute.AVERAGE);
	}
	
	public void setActionPoints(int actionPoints) {
		this.actionPoints = actionPoints;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setBackground(String background) {
		this.background = background;
	}

	public void setBody(Attribute body) {
		this.body = body;
	}

	private void setCombatStats(CombatStats combatStats) {
		this.combatStats = combatStats;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}
	
	private void setFeatures(FeatureManager features) {
		this.features = features;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}
	
	public void setInjuries(int injuries) {
		this.injuries = injuries;
	}
	
	public void setMind(Attribute mind) {
		this.mind = mind;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSize(String size) {
		this.size = size;
	}

	public void setSpirit(Attribute spirit) {
		this.spirit = spirit;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
}
