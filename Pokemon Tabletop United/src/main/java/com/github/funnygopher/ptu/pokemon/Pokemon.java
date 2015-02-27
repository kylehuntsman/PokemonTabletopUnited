package com.github.funnygopher.ptu.pokemon;

import java.util.List;

import com.github.funnygopher.ptu.AbilityManager;
import com.github.funnygopher.ptu.CombatStatManager;
import com.github.funnygopher.ptu.move.MoveManager;
import com.github.funnygopher.ptu.pokemon.species.Species;
import com.github.funnygopher.ptu.pokemon.species.Type;
import com.github.funnygopher.ptu.trainer.inventory.item.Item;
import com.github.funnygopher.ptu.SkillManager;

public class Pokemon {
	private Species species;
	private String nickname;
	private int level;
	private Item heldItem;
	private int loyalty;
	private String gender;
	private Nature nature;
	private AbilityManager abilities;
	private int overland, swim, longJump, highJump, 
	injuries, tutorPoints; 
	private CombatStatManager combatStats;
	private MoveManager moves;
	private SkillManager skills;
	private ContestStatManager contestStats;
	private List<Vitamin> vitmains;
	private List<Poffin> poffins;   
	private List<PokeEdge> edges;   
	private String notes;
	private Boolean isShiny;
	
	public Pokemon(Species species, String nickname, int level, Item heldItem,
			int loyalty, String gender, Nature nature,
			AbilityManager abilities, int overland, int swim, int longJump,
			int highJump, int injuries, int tutorPoints,
			CombatStatManager combatStats, MoveManager moves,
			SkillManager skills, ContestStatManager contestStats,
			List<Vitamin> vitmains, List<Poffin> poffins, List<PokeEdge> edges,
			String notes, Boolean isShiny) {
		this.species = species;
		this.nickname = nickname;
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
		this.tutorPoints = tutorPoints;
		this.combatStats = combatStats;
		this.moves = moves;
		this.skills = skills;
		this.contestStats = contestStats;
		this.vitmains = vitmains;
		this.poffins = poffins;
		this.edges = edges;
		this.notes = notes;
		this.isShiny = isShiny;
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

	public Boolean isShiny() {
		return isShiny;
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

	public int getTutorPoints() {
		return tutorPoints;
	}

	public Type getType1() {
		return species.getType1();
	}

	public Type getType2() {
		return species.getType2();
	}

	public List<Vitamin> getVitmains() {
		return vitmains;
	}

	public void setAbilities(AbilityManager abilities) {
		this.abilities = abilities;
	}

	public void setCombatStats(CombatStatManager combatStats) {
		this.combatStats = combatStats;
	}

	public void setContestStats(ContestStatManager contestStats) {
		this.contestStats = contestStats;
	}

	public void setEdges(List<PokeEdge> edges) {
		this.edges = edges;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setHeldItem(Item heldItem) {
		this.heldItem = heldItem;
	}

	public void setHighJump(int highJump) {
		this.highJump = highJump;
	}

	public void setInjuries(int injuries) {
		this.injuries = injuries;
	}

	public void setIsShiny(Boolean isShiny) {
		this.isShiny = isShiny;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setLongJump(int longJump) {
		this.longJump = longJump;
	}



	public void setLoyalty(int loyalty) {
		this.loyalty = loyalty;
	}



	public void setMoves(MoveManager moves) {
		this.moves = moves;
	}



	public void setNature(Nature nature) {
		this.nature = nature;
	}



	public void setNickname(String nickname) {
		this.nickname = nickname;
	}



	public void setNotes(String notes) {
		this.notes = notes;
	}



	public void setOverland(int overland) {
		this.overland = overland;
	}



	public void setPoffins(List<Poffin> poffins) {
		this.poffins = poffins;
	}



	public void setSkills(SkillManager skills) {
		this.skills = skills;
	}



	public void setSpecies(Species species) {
		this.species = species;
	}



	public void setSwim(int swim) {
		this.swim = swim;
	}



	public void setTutorPoints(int tutorPoints) {
		this.tutorPoints = tutorPoints;
	}

	public void setVitmains(List<Vitamin> vitmains) {
		this.vitmains = vitmains;
	}
}
