package com.ptu.pokemon.species;
import java.util.List;

import com.ptu.move.Move;

public class MoveList {
	private List<Move> levelUpMoveList, tmhmMoveList, eggMoveList, tutorMoveList;
	
	public MoveList(List<Move> levelUpMoveList, List<Move> tmhmMoveList,
			List<Move> eggMoveList, List<Move> tutorMoveList) {
		this.levelUpMoveList = levelUpMoveList;
		this.tmhmMoveList = tmhmMoveList;
		this.eggMoveList = eggMoveList;
		this.tutorMoveList = tutorMoveList;
	}
	
	public List<Move> getLevelUpMoveList() {
		return levelUpMoveList;
	}

	public List<Move> getTmhmMoveList() {
		return tmhmMoveList;
	}

	public List<Move> getEggMoveList() {
		return eggMoveList;
	}

	public List<Move> getTutorMoveList() {
		return tutorMoveList;
	}
}
