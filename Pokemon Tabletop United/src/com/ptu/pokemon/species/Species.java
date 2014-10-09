package com.ptu.pokemon.species;


import com.ptu.Ability;
import com.ptu.CombatStatManager;
import com.ptu.SkillManager;
import com.ptu.pokemon.Size;

import java.util.List;

public class Species {

	private String name;
	private int gameGeneration;
	private int stage;
	private CombatStatManager combatStats;
	private Type type1, type2;
	private List<Ability> basicAbilities, advancedAbilities;
	private Ability highAbility;
	private List<Evolution> evolution;
	// It is important to separate size and height because
	// size is used to determine how large a Pokemon is on
	// the playing grid.
	private Size size; 
	// Height measured in meters
	private int height, weight;
	private double genderRatio;
	private EggGroup eggGroup1 , eggGroup2;
	private int hatchRate;
	private List<Diet> diet;
	private List<Habitat> habitat;
	private int overland, swim, longJump, highJump; 
	private List<Capability> cabilities;
	private SkillManager skills;
	private MoveList moveList;
	// Things to add that will take some extra thought 
	//private Image pokemonImage;
	//private Image miniImage;
	//private Image eggImage;
	//private Mega megaEvolution;
	//private List<Forms> forms;
	
	public Species(String name, int gameGeneration, int stage,
			CombatStatManager combatStats, Type type1, Type type2,
			List<Ability> basicAbilities, List<Ability> advancedAbilities,
			Ability highAbility, List<Evolution> evolution, Size size,
			int height, int weight, double genderRatio, EggGroup eggGroup1,
			EggGroup eggGroup2, int hatchRate, List<Diet> diet,
			List<Habitat> habitat, int overland, int swim, int longJump,
			int highJump, List<Capability> cabilities, SkillManager skills,
			MoveList moveList) {
		this.name = name;
		this.gameGeneration = gameGeneration;
		this.stage = stage;
		this.combatStats = combatStats;
		this.type1 = type1;
		this.type2 = type2;
		this.basicAbilities = basicAbilities;
		this.advancedAbilities = advancedAbilities;
		this.highAbility = highAbility;
		this.evolution = evolution;
		this.size = size;
		this.height = height;
		this.weight = weight;
		this.genderRatio = genderRatio;
		this.eggGroup1 = eggGroup1;
		this.eggGroup2 = eggGroup2;
		this.hatchRate = hatchRate;
		this.diet = diet;
		this.habitat = habitat;
		this.overland = overland;
		this.swim = swim;
		this.longJump = longJump;
		this.highJump = highJump;
		this.cabilities = cabilities;
		this.skills = skills;
		this.moveList = moveList;
	}
	
	public CombatStatManager getCombatStats() {
		return combatStats;
	}
	
	public List<Ability> getAdvancedAbilities() {
		return advancedAbilities;
	}
	public int getHatchRate() {
		return hatchRate;
	}
	public List<Ability> getBasicAbilities() {
		return basicAbilities;
	}
	public List<Capability> getCabilities() {
		return cabilities;
	}
	public List<Diet> getDiet() {
		return diet;
	}
	public EggGroup getEggGroup1() {
		return eggGroup1;
	}
	public EggGroup getEggGroup2() {
		return eggGroup2;
	}
	public List<Evolution> getEvolution() {
		return evolution;
	}
	public int getGameGeneration() {
		return gameGeneration;
	}
	public double getGenderRatio() {
		return genderRatio;
	}
	public List<Habitat> getHabitat() {
		return habitat;
	}
	public int getHeight() {
		return height;
	}
	public Ability getHighAbility() {
		return highAbility;
	}
	public int getHighJump() {
		return highJump;
	}
	public int getLongJump() {
		return longJump;
	}
	public MoveList getMoveList() {
		return moveList;
	}
	public String getName() {
		return name;
	}
	public int getOverland() {
		return overland;
	}
	public Size getSize() {
		return size;
	}
	public SkillManager getSkills() {
		return skills;
	}
	public int getStage() {
		return stage;
	}
	public int getSwim() {
		return swim;
	}
	public Type getType1() {
		return type1;
	}
	public Type getType2() {
		return type2;
	}
	public int getWeight() {
		return weight;
	}
	
	
}
