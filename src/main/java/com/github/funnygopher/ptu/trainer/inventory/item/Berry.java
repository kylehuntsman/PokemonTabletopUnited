package com.github.funnygopher.ptu.trainer.inventory.item;

public class Berry extends Item {
	
	private int tier;
	
	public Berry(int tier, String name, String effect, int cost, int quantity) {
		super(name, effect, cost, quantity);
		this.tier = tier;
	}

	public int getTier() {
		return tier;
	}

	public void setTier(int tier) {
		this.tier = tier;
	}
}
