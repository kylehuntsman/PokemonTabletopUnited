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
	private int overland, swim, longJump, highJump, injuries; 
	private CombatStatManager combatStats;
	private MoveManager moves;
	private SkillManager skills;
	private ContestStatManager contestStats;
	private VitaminManager vitmains; //Currently does nothing
	private PoffinManager poffins;   //Currently does nothing
	private PokeEdgeManager edges;   //Currently does nothing
}
