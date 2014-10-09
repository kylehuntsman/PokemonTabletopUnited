package com.ptu;

import java.util.ArrayList;
import java.util.List;

public class AbilityManager {
	
	private List<Ability> abilities;
	
	private AbilityManager() {
		abilities = new ArrayList<Ability>();
	}
	
	public void add(Ability ability) {
		abilities.add(ability);
	}
	
	public boolean contains(Ability ability) {
		return abilities.contains(ability);
	}
	
	public void remove(Ability ability) {
		abilities.remove(ability);
	}
}
