package com.github.funnygopher.ptu.trainer.equipment;

public class EquipmentManager {

	private Equipment head, mainHand, offHand, body, feet, accessory;
	
	public EquipmentManager() {}

	public Equipment getAccessory() {
		return accessory;
	}

	public Equipment getBody() {
		return body;
	}

	public Equipment getFeet() {
		return feet;
	}

	public Equipment getHead() {
		return head;
	}

	public Equipment getMainHand() {
		return mainHand;
	}

	public Equipment getOffHand() {
		return offHand;
	}
	
	public boolean hasAccessory() {
		return accessory == null;
	}
	
	public boolean hasBody() {
		return body == null;
	}
	
	public boolean hasFeet() {
		return feet == null;
	}
	
	public boolean hasHead() {
		return head == null;
	}
	
	public boolean hasMainHand() {
		return mainHand == null;
	}
	
	public boolean hasOffHand() {
		return offHand == null;
	}

	public void equipAccessory(Equipment accessory) {
		this.accessory = accessory;
	}

	public void setBody(Equipment body) {
		this.body = body;
	}

	public void setFeet(Equipment feet) {
		this.feet = feet;
	}

	public void setHead(Equipment head) {
		this.head = head;
	}

	public void setMainHand(Equipment mainHand) {
		this.mainHand = mainHand;
	}

	public void setOffHand(Equipment offHand) {
		this.offHand = offHand;
	}
	
	public void removeAccessory() {
		this.accessory = null;
	}

	public void removeBody() {
		this.body = null;
	}

	public void removeFeet() {
		this.feet = null;
	}

	public void removeHead() {
		this.head = null;
	}

	public void removeMainHand() {
		this.mainHand = null;
	}

	public void removeOffHand() {
		this.offHand = null;
	}
}
