package com.ptu;

/**
 * The <code>Ability</code> class represents a special type of trait that a
 * {@link com.ptu.trainer.Trainer <code>Trainer</code>} or
 * {@link com.ptu.pokemon.Pokemon <code>Pokemon</code>} can have.
 */
public class Ability {
	private String name;
	private Frequency frequency;
	private String target;
	private String trigger;
	private String effect;

	/**
	 * Instantiates an <code>Ability</code> object.
	 * 
	 * @param name
	 *            - The name of the of the Ability
	 * @param frequency
	 *            - The frequency that the Ability can be activated
	 * @param target
	 *            - The target of the Ability
	 * @param trigger
	 *            - The event that triggers the Ability
	 * @param effect
	 *            - The effect of the Ability
	 */
	public Ability(String name, Frequency frequency, String target,
			String trigger, String effect) {
		this.name = name;
		this.frequency = frequency;
		this.target = target;
		this.trigger = trigger;
		this.effect = effect;
	}

	/**
	 * Gets the effect description
	 * 
	 * @return effect description
	 */
	public String getEffect() {
		return effect;
	}

	/**
	 * Gets the frequency
	 * 
	 * @return frequency
	 */
	public Frequency getFrequency() {
		return frequency;
	}

	/**
	 * Gets the name of the ability
	 * 
	 * @return name of the ability
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the target description
	 * 
	 * @return target description
	 */
	public String getTarget() {
		return target;
	}

	/**
	 * Gets the trigger description
	 * 
	 * @return trigger description
	 */
	public String getTrigger() {
		return trigger;
	}
}
