package com.ptu.trainer.inventory;

import java.util.ArrayList;
import java.util.List;

import com.ptu.trainer.inventory.item.Item;

public class Inventory {
	
	private List<Item> items;
	
	public Inventory() {
		setItems(new ArrayList<Item>());
	}

	public void add(Item item) {
		items.add(item);
	}

	public List<Item> getItems() {
		return items;
	}
	
	public void remove(Item item) {
		items.remove(item);
	}
	
	private void setItems(List<Item> items) {
		this.items = items;
	}
}
