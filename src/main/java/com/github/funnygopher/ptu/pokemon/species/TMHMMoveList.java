package com.github.funnygopher.ptu.pokemon.species;

import java.util.List;

import com.github.funnygopher.ptu.trainer.inventory.item.HM;
import com.github.funnygopher.ptu.trainer.inventory.item.TM;

public class TMHMMoveList {
	
	private List<HM> hms;
	private List<TM> tms;
	
	public TMHMMoveList(List<HM> hms, List<TM> tms) {
		this.hms = hms;
		this.tms = tms;
	}
	
	public boolean containsHM(HM hm) {
		return hms.contains(hm);
	}
	
	public boolean containsTM(TM tm) {
		return tms.contains(tm);
	}
}
