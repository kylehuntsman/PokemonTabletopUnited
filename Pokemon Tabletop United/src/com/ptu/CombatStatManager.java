package com.ptu;

public class CombatStatManager {
	
	private int hp, attack, defense, specialAttack, specialDefense, speed;
	
	/**
	 * Instantiates a CombatStats object with the specified stat values
	 * 
	 * @param hp - The HP stat value
	 * @param attack - The Attack stat value
	 * @param defense - The Defense stat value
	 * @param spAttack - The Special Attack stat value
	 * @param spDefense - The Special Defense stat value
	 * @param speed - The Speed stat value
	 */
	public CombatStatManager(int hp, int attack, int defense, int specialAttack, int specialDefense, int speed) {
		this.hp = hp;
		this.attack = attack;
		this.defense = defense;
		this.specialAttack = specialAttack;
		this.specialDefense = specialDefense;
		this.speed = speed;
	};
	
	/**
	 * Gets the Attack stat
	 * 
	 * @return Attack stat
	 */
	public int getAttack() {
		return attack;
	}
	
	/**
	 * Gets the Defense stat
	 * 
	 * @return Defense stat 
	 */
	public int getDefense() {
		return defense;
	}
	
	/**
	 * Gets the HP stat
	 * 
	 * @return HP stat 
	 */
	public int getHP() {
		return hp;
	}
	
	/**
	 * Gets the Physical Evasion stat
	 *
	 * @return Physical Evasion stat 
	 */
	public int getPhysicalEvasion() {
		return defense/5;
	}
	
	/**
	 * Gets the Special Attack stat
	 * 
	 * @return Special Attack stat 
	 */
	public int getSpecialAttack() {
		return specialAttack;
	}
	
	/**
	 * Gets the Special Defense stat
	 * 
	 * @return Special Defense stat 
	 */
	public int getSpecialDefense() {
		return specialDefense;
	}
	
	/**
	 * Gets the Special Evasion stat
	 * 
	 * @return Special Evasion stat 
	 */
	public int getSpecialEvasion() {
		return specialDefense/5;
	}
	
	/**
	 * Gets the Speed stat
	 * 
	 * @return Speed stat 
	 */
	public int getSpeed() {
		return speed;
	}
	
	/**
	 * Gets the Speed Evasion stat
	 * 
	 * @return Speed Evasion stat 
	 */
	public int getSpeedEvasion() {
		return speed/5;
	}
	
	/**
	 * Sets the Attack stat value
	 * 
	 * @param value - The new Attack stat value
	 */
	public void setAttack(int value) {
		attack = value;
	}
	
	/**
	 * Sets the Defense stat value
	 * 
	 * @param value - The new Defense stat value
	 */
	public void setDefense(int value) {
		defense = value;
	}
	
	/**
	 * Sets the HP stat value
	 * 
	 * @param value - The new HP stat value
	 */
	public void setHP(int value) {
		hp = value;
	}
	
	/**
	 * Sets the Special Attack stat value
	 * 
	 * @param value - The new Special Attack stat value
	 */
	public void setSpecialAttack(int value) {
		specialAttack = value;
	}
	
	/**
	 * Sets the Special Defense stat value
	 * 
	 * @param value - The new Special Defense stat value
	 */
	public void setSpecialDefense(int value) {
		specialDefense = value;
	}
	
	/**
	 * Sets the Speed stat value
	 * 
	 * @param value - The new Speed stat value
	 */
	public void setSpeed(int value) {
		attack = value;
	}
}
