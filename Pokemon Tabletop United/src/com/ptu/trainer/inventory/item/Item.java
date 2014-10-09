package com.ptu.trainer.inventory.item;

public class Item {
	
	private String name;
	private String effect;
	private int cost;
	private int quantity;
	
	public Item(String name, String effect, int cost, int quantity) {
		this.name = name;
		this.effect = effect;
		this.cost = cost;
		this.setQuantity(quantity);
	}

	public int getCost() {
		return cost;
	}

	public String getEffect() {
		return effect;
	}

	public String getName() {
		return name;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
