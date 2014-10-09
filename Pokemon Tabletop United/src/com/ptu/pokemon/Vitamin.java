package com.ptu.pokemon;

import com.ptu.CombatStat;
import com.ptu.trainer.inventory.item.Item;

public class Vitamin extends Item {

	private CombatStat stat;
	private int statIncrease;

	public Vitamin(String name, String effect, int cost, int quantity,
			CombatStat stat, int statIncrease) {
		super(name, effect, cost, quantity);
		this.stat = stat;
		this.statIncrease = statIncrease;
	}

	public CombatStat getStat() {
		return stat;
	}


	public int getStatIncrease() {
		return statIncrease;
	}
}
