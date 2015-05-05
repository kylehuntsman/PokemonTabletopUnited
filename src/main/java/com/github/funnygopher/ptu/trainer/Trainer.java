package com.github.funnygopher.ptu.trainer;

import com.github.funnygopher.ptu.*;
import com.github.funnygopher.ptu.trainer.inventory.Inventory;
import com.github.funnygopher.ptu.trainer.equipment.EquipmentManager;
import com.github.funnygopher.ptu.trainer.feature.FeatureManager;

public class Trainer {

    private String name, gender, appearance;
    private Background background;
    private Size size;
    private int age, weight;

    private int level, exp, actionPoints, hitPoints, injuries;
    private int money;

	private SkillManager skills;
    private EdgeManager edges;
    private FeatureManager features;
	private CombatStatManager combatStats;
	private AbilityManager abilities;

	private Inventory inventory;
	private EquipmentManager equipment;
	
	/**
	 * Instantiates a Trainer object
	 */
	public Trainer() {
        name = "";
        gender= "";
        appearance = "";

        background = new Background();
        size = Size.MEDIUM;

        age = 0;
        weight = 0;

        level = 1;
        exp = 0;
        actionPoints = getMaxActionPoints();
        hitPoints = getMaxHitPoints();
        injuries = 0;
        money = 0;

		skills = new SkillManager();
        edges = new EdgeManager();
        features = new FeatureManager();
		combatStats = new CombatStatManager();
        abilities = new AbilityManager();
        inventory = new Inventory();
        equipment = new EquipmentManager();
	}

    /**
     * Player created Trainer constructor
     */
    public Trainer(TrainerBuilder builder) {
        name = builder.getName();
        gender = builder.getGender();
        appearance = builder.getAppearance();
        background = builder.getBackground();
        size = builder.getSize();
        age = builder.getAge();
        weight = builder.getWeight();
        level = builder.getLevel();
        exp = builder.getExp();
        actionPoints = getMaxActionPoints();
        hitPoints = builder.getHitPoints();
        injuries = builder.getInjuries();
        money = builder.getMoney();

        skills = builder.getSkills();
        edges = builder.getEdges();
        features = builder.getFeatures();
        combatStats = builder.getCombatStats();
        abilities = builder.getAbilities();
        inventory = builder.getInventory();
        equipment = builder.getEquipment();
    }
	
	public AbilityManager getAbilities() {
		return abilities;
	}
	
	public int getActionPoints() {
		return actionPoints;
	}

	public int getAge() {
		return age;
	}

	public Background getBackground() {
		return background;
	}
	
	public CombatStatManager getCombatStats() {
		return combatStats;
	}
	
	public String getAppearanceDescriptionDescription() {
		return appearance;
	}
	
	public EdgeManager getEdges() {
		return edges;
	}
	
	public EquipmentManager getEquipment() {
		return equipment;
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
		
		if(skills.getAcrobatics().getValue() >= Skill.ADEPT.getValue())
			highJump++;
		if(skills.getAcrobatics().getValue() >= Skill.MASTER.getValue())
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

	public Inventory getInventory() {
		return inventory;
	}

    public int getLevel() {
        return level;
    }

	public int getLongJump() {
		return skills.getAcrobatics().getValue() / 2;
	}

	public int getMaxHitPoints() {
		return (level * 2) + (combatStats.getHP() * 3) + 10;
	}

    public int getMaxActionPoints() {
        return 5 + (getLevel() / 5);
    }

	public int getMoney() {
		return money;
	}

	public String getName() {
		return name;
	}

	public int getOverland() {
		return 3 + ((skills.getAcrobatics().getValue() + skills.getAthletics().getValue()) / 2);
	}

	public int getPower() {
		int power = 4;

		if(skills.getAthletics().getValue() >= Skill.NOVICE.getValue())
			power++;
		if(skills.getCombat().getValue() >= Skill.ADEPT.getValue())
			power++;
		
		return power;
	}

	public Size getSize() {
		return size;
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

	public void setActionPoints(int actionPoints) {
		this.actionPoints = actionPoints;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setAppearance(String appearance) {
		this.appearance = appearance;
	}
	
	public void setExp(int exp) {
		this.exp = exp;
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

	public void setMoney(int money) {
		this.money = money;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}
