package com.ptu.pokemon;

import java.util.List;

import com.ptu.AbilityManager;
import com.ptu.CombatStatManager;
import com.ptu.SkillManager;
import com.ptu.move.MoveManager;
import com.ptu.pokemon.species.Species;
import com.ptu.pokemon.species.Type;
import com.ptu.trainer.inventory.item.Item;

public class Pokemon {
	private Species species;
	private String nickname;
	private Type type1, type2;
	private int level;
	private Item heldItem;
	private int loyalty;
	private String gender;
	private Nature nature;
	private AbilityManager abilities;
	private int overland, swim, longJump, highJump, 
	injuries, tutorPoint; 
	private CombatStatManager combatStats;
	private MoveManager moves;
	private SkillManager skills;
	private ContestStatManager contestStats;
	private List<Vitamin> vitmains; //Currently does nothing
	private List<Poffin> poffins;   //Currently does nothing
	private List<PokeEdge> edges;   //Currently does nothing
	private int currentTutorPoints;
	private String notes;
	
	public Pokemon(Species species, String nickname, Type type1, Type type2,
			int level, Item heldItem, int loyalty, String gender,
			Nature nature, AbilityManager abilities, int overland, int swim,
			int longJump, int highJump, int injuries, int tutorPoint,
			CombatStatManager combatStats, MoveManager moves,
			SkillManager skills, ContestStatManager contestStats,
			List<Vitamin> vitmains, List<Poffin> poffins, List<PokeEdge> edges,
			int currentTutorPoints, String notes) {
		this.species = species;
		this.nickname = nickname;
		this.type1 = type1;
		this.type2 = type2;
		this.level = level;
		this.heldItem = heldItem;
		this.loyalty = loyalty;
		this.gender = gender;
		this.nature = nature;
		this.abilities = abilities;
		this.overland = overland;
		this.swim = swim;
		this.longJump = longJump;
		this.highJump = highJump;
		this.injuries = injuries;
		this.tutorPoint = tutorPoint;
		this.combatStats = combatStats;
		this.moves = moves;
		this.skills = skills;
		this.contestStats = contestStats;
		this.vitmains = vitmains;
		this.poffins = poffins;
		this.edges = edges;
		this.currentTutorPoints = currentTutorPoints;
		this.notes = notes;
	}

	public AbilityManager getAbilities() {
		return abilities;
	}

	public CombatStatManager getCombatStats() {
		return combatStats;
	}

	public ContestStatManager getContestStats() {
		return contestStats;
	}

	public int getCurrentTutorPoints() {
		return currentTutorPoints;
	}

	public List<PokeEdge> getEdges() {
		return edges;
	}

	public String getGender() {
		return gender;
	}

	public Item getHeldItem() {
		return heldItem;
	}

	public int getHighJump() {
		return highJump;
	}

	public int getInjuries() {
		return injuries;
	}

	public int getLevel() {
		return level;
	}

	public int getLongJump() {
		return longJump;
	}

	public int getLoyalty() {
		return loyalty;
	}

	public MoveManager getMoves() {
		return moves;
	}

	public Nature getNature() {
		return nature;
	}

	public String getNickname() {
		return nickname;
	}

	public String getNotes() {
		return notes;
	}

	public int getOverland() {
		return overland;
	}

	public List<Poffin> getPoffins() {
		return poffins;
	}

	public SkillManager getSkills() {
		return skills;
	}

	public Species getSpecies() {
		return species;
	}

	public int getSwim() {
		return swim;
	}

	public int getTutorPoint() {
		return tutorPoint;
	}

	public Type getType1() {
		return type1;
	}

	public Type getType2() {
		return type2;
	}

	public List<Vitamin> getVitmains() {
		return vitmains;
	}
}
