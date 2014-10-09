package com.ptu.trainer.feature;

public enum Tag {
	CLASS("Class"), STAT("+Stat"), RANKED("Ranked"), BRANCH("Branch"), ORDERS("Orders"), TRAINING("Training");
	
	private String value;
	
	Tag(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
