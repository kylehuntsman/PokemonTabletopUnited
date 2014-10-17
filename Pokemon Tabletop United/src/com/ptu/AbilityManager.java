package com.ptu;

import java.util.ArrayList;
import java.util.List;

/**
 * The <code> AbilityManager </code> represents an object that manages a list of
 * {@link com.ptu.Ability <code>Ability</code>} objects.
 */
public class AbilityManager {

	private List<Ability> abilities;

	/**
	 * Instantiates an <code>AbilityManager</code> object.
	 */
	private AbilityManager() {
		abilities = new ArrayList<Ability>();
	}

	/**
	 * Adds an {@link com.ptu.Ability <code>Ability</code>} object to this
	 * manager.
	 * 
	 * @param ability
	 *            - The {@link com.ptu.Ability <code>Ability</code>} object to
	 *            be added
	 */
	public void add(Ability ability) {
		abilities.add(ability);
	}

	/**
	 * Checks if the given {@link com.ptu.Ability <code>Ability</code>} object
	 * is contained within this manager.
	 * 
	 * @param ability
	 *            - The {@link com.ptu.Ability <code>Ability</code>} object to
	 *            be checked
	 * @return <code> true </code> if the given {@link com.ptu.Ability
	 *         <code>Ability</code>} object is contained within this manager
	 */
	public boolean contains(Ability ability) {
		return abilities.contains(ability);
	}

	/**
	 * Gets an {@link com.ptu.Ability <code>Ability</code>} object at a given
	 * index.
	 * 
	 * @param index
	 *            - The given index value
	 * @return the {@link com.ptu.Ability <code>Ability</code>} at the given
	 *         index
	 */
	public Ability get(int index) {
		return abilities.get(index);
	}

	public void remove(Ability ability) {
		abilities.remove(ability);
	}
}
