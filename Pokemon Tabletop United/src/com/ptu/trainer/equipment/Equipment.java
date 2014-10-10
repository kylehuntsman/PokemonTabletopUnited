package com.ptu.trainer.equipment;

import com.ptu.trainer.inventory.item.Item;

public class Equipment extends Item {
	
	private EquipmentSlot slot;
	private EquipmentType type;
	
	public Equipment(String name, String effect, int cost, int quantity, EquipmentSlot slot, EquipmentType type) {
		super(name, effect, cost, quantity);
		this.slot = slot;
		this.type = type;
	}
	
	public EquipmentSlot getSlot() {
		return slot;
	}

	public EquipmentType getType() {
		return type;
	}
}
