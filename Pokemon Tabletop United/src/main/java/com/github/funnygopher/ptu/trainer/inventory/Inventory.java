package com.github.funnygopher.ptu.trainer.inventory;

import java.util.ArrayList;
import java.util.List;

import com.github.funnygopher.ptu.trainer.inventory.item.Item;

public class Inventory {
	
	private List<Item> items;
	
	public Inventory() {
		items = new ArrayList<Item>();
	}

	public void add(Item item) {
		items.add(item);
	}
	
	public boolean contains(Item item) {
		return items.contains(item);
	}

	public Item get(int index) {
		return items.get(index);
	}
	
	public void remove(Item item) {
		items.remove(item);
	}
}
