package com.github.funnygopher.ptu;

//TODO Link somethings in this skill description

/**
 * The <code>Skill</code> enum represent conscious interest and training that
 * your character uses to interact with the world, as well as
 * incorporating a Trainer’s natural talent. Skills are used
 * for the most basic interactions between yourself and the
 * game world, and they help determine what Classes and
 * Features your Trainer qualifies for.
 */
public enum Skill {
	PATHETIC(1, 1), UNTRAINED(2, 1), NOVICE(3, 1), ADEPT(4, 2), EXPERT(5, 6), MASTER(
			6, 12);

	private int value;
	private int levelPreReq;

	/**
	 * Instantiates a <code>Skill</code> object.
	 * 
	 * @param value
	 *            - The numerical value of a type of skill
	 * @param levelPreReq
	 *            - The required level to attain that skill level
	 */
	private Skill(int value, int levelPreReq) {
		this.value = value;
	}

	/**
	 * Gets the level prerequisite for the skill level
	 * 
	 * @return level pre requisite
	 */
	public int getLevelPreReq() {
		return levelPreReq;
	}

	/**
	 * Gets the value
	 * 
	 * @return value
	 */
	public int getValue() {
		return value;
	}
}
