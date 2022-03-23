package com.adventuregame;

public class Weapon extends Tool {
	private int damage;
	
	public Weapon(int id, String name, int damage, int price) {
		super(id, name, price);
		this.damage = damage;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	@Override
	public String toString() {
		return this.getName() + " \tDamage: " + this.getDamage() + "\tPrice: " + this.getPrice();
	}
	
	
}
