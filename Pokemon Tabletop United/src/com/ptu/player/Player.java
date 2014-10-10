package com.ptu.player;

import java.util.Date;

import com.ptu.trainer.Trainer;

public class Player {
	private String name;
	private Date startingDate; 
	private Trainer trainer;
	
	public Player(String name, Date startingDate, Trainer trainer) {
		this.name = name;
		this.startingDate = startingDate;
		this.trainer = trainer;
	}

	public String getName() {
		return name;
	}

	public Date getStartingDate() {
		return startingDate;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}	
}
