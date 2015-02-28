package com.github.funnygopher.ptu.pokemon;

public class ContestStatManager {
	private int beauty, cool, cute, smart, tough;

	public ContestStatManager(int beauty, int cool, int cute, int smart,
			int tough) {
		this.beauty = beauty;
		this.cool = cool;
		this.cute = cute;
		this.smart = smart;
		this.tough = tough;
	}

	
	
	public int getBeauty() {
		return beauty;
	}



	public int getCool() {
		return cool;
	}



	public int getCute() {
		return cute;
	}



	public int getSmart() {
		return smart;
	}



	public int getTough() {
		return tough;
	}



	public void setBeauty(int beauty) {
		this.beauty = beauty;
	}

	public void setCool(int cool) {
		this.cool = cool;
	}

	public void setCute(int cute) {
		this.cute = cute;
	}

	public void setSmart(int smart) {
		this.smart = smart;
	}

	public void setTough(int tough) {
		this.tough = tough;
	}
}
