package com.ptu.pokemon.species;


import com.ptu.Ability;
import com.ptu.CombatStatManager;
import com.ptu.pokemon.Size;
import com.ptu.pokemon.SkillList;

import java.util.List;

public class Species {

	private String name;
	private CombatStatManager baseStats;
	private Type type1, type2;
	private List<Ability> basicAbilities, advancedAbilities;
	private Ability highAbility;
	private List<Evolution> evolution;
	// It is important to separate size and height because
	// size is used to determine how large a Pokemon is on
	// the playing grid.
	private Size size; 
	private String height; //could an int
	private int weight;
	private double genderRatio;
	private EggGroup eggGroup1 , eggGroup2;
	private List<Diet> diet;
	private List<Habitat> habitat;
	private int overland, swim, longJump, highJump; 
	private List<Capability> cabilities;
	private SkillList skillList;
	private MoveList moveList;
	// Things to add that will take some extra thought 
	//private Image pokemonImage;
	//private Image eggImage;
	//private Mega megaEvolution;
	//private List<Forms> forms;
}
