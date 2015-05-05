package com.github.funnygopher.ptu.trainer;

import com.github.funnygopher.ptu.AbilityManager;
import com.github.funnygopher.ptu.CombatStatManager;
import com.github.funnygopher.ptu.Size;
import com.github.funnygopher.ptu.SkillManager;
import com.github.funnygopher.ptu.trainer.equipment.EquipmentManager;
import com.github.funnygopher.ptu.trainer.feature.FeatureManager;
import com.github.funnygopher.ptu.trainer.inventory.Inventory;

public class TrainerBuilder {

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

    public TrainerBuilder() {
        name = "";
        gender= "";
        appearance = "";

        background = new Background();
        size = Size.MEDIUM;

        age = 0;
        weight = 0;

        level = 1;
        exp = 0;
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

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getAppearance() {
        return appearance;
    }

    public Background getBackground() {
        return background;
    }

    public Size getSize() {
        return size;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public int getLevel() {
        return level;
    }

    public int getExp() {
        return exp;
    }

    public int getActionPoints() {
        return actionPoints;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getInjuries() {
        return injuries;
    }

    public int getMoney() {
        return money;
    }

    public SkillManager getSkills() {
        return skills;
    }

    public EdgeManager getEdges() {
        return edges;
    }

    public CombatStatManager getCombatStats() {
        return combatStats;
    }

    public FeatureManager getFeatures() {
        return features;
    }

    public AbilityManager getAbilities() {
        return abilities;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public EquipmentManager getEquipment() {
        return equipment;
    }

    public TrainerBuilder name(String name) {
        this.name = name;
        return this;
    }

    public TrainerBuilder gender(String gender) {
        this.gender = gender;
        return this;
    }

    public TrainerBuilder appearance(String appearance) {
        this.appearance = appearance;
        return this;
    }

    public TrainerBuilder background(Background background) {
        this.background = background;
        return this;
    }

    public TrainerBuilder age(int age) {
        this.age = age;
        return this;
    }

    public TrainerBuilder weight(int weight) {
        this.weight = weight;
        return this;
    }

    public TrainerBuilder level(int level) {
        this.level = level;

        return this;
    }

    public TrainerBuilder exp(int exp) {
        if(exp >= 0 && exp <= 9)
            this.exp = exp;
        return this;
    }

    public TrainerBuilder hitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
        return this;
    }

    public TrainerBuilder injuries(int injuries) {
        this.injuries = injuries;
        return this;
    }

    public TrainerBuilder money(int money) {
        this.money = money;
        return this;
    }

    public Trainer build() {
        return new Trainer(this);
    }
}