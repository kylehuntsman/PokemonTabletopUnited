package com.github.funnygopher.ptu.pokemon;

import com.github.funnygopher.ptu.trainer.inventory.item.Item;

public class Poffin extends Item {

	private ContestStat stat;
	private int statIncrease;
	
	public Poffin(String name, String effect, int cost, int quantity,
			ContestStat stat, int statIncrease) {
		super(name, effect, cost, quantity);
		this.stat = stat;
		this.statIncrease = statIncrease;
	}

	public ContestStat getStat() {
		return stat;
	}

	public int getStatIncrease() {
		return statIncrease;
	}
}
