package com.ptu.pokemon;

import java.util.List;

import com.ptu.AbilityManager;
import com.ptu.CombatStatManager;
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
	private CombatStatManager combatStats;
	
}
