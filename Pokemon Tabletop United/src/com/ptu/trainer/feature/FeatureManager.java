package com.ptu.trainer.feature;

import java.util.ArrayList;
import java.util.List;

public class FeatureManager {
	
	private List<Feature> features;
	
	public FeatureManager() {
		features = new ArrayList<Feature>();
	}
	
	public void add(Feature feature) {
		features.add(feature);
	}
	
	public boolean contains(Feature feature) {
		return features.contains(feature);
	}
	
	public Feature get(int index) {
		return features.get(index);
	}
	
	public void remove(Feature feature) {
		features.remove(feature);
	}
}
