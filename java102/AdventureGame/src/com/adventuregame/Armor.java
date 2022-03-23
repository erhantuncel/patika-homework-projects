package com.adventuregame;

public class Armor extends Tool {

	private int protection;

	public Armor(int id, String name, int protection, int price) {
		super(id, name, price);
		this.protection = protection;
	}

	public int getProtection() {
		return protection;
	}

	public void setProtection(int protection) {
		this.protection = protection;
	}

	@Override
	public String toString() {
		return this.getName() + "\tProtection: " + this.getProtection() + "\tPrice: " + this.getPrice();
	}
	
	
}
