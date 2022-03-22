package com.adventuregame;

public class Armor extends Tool {

	private int protection;
	
	public Armor(int protection) {
		this.protection = protection;
	}

	public int getProtection() {
		return protection;
	}

	public void setProtection(int protection) {
		this.protection = protection;
	}
	
	
}
