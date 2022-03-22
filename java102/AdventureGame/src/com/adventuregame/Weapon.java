package com.adventuregame;

public class Weapon extends Tool {
	private int damage;

	public Weapon(int damage) {
		this.damage = damage;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
}
