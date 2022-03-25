package com.adventuregame;

public class Warrior extends Rival {

	private Weapon weapon;	
	private Armor armor;

	public Warrior(int id, String name, int damage, int health, int money) {
		super(id, name, damage, health, money);
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public Armor getArmor() {
		return armor;
	}


	public void setArmor(Armor armor) {
		this.armor = armor;
	}

	
	
	@Override
	public String toString() {
		return this.getName() + 
				"\tDamage: " + this.getDamage() + "\tHealth: " + this.getHealth() + 
				"\tMoney: " + this.getMoney();
	}

	@Override
	public void hit(Rival rival) {
		rival.setHealth(rival.getHealth() - getTotalDamage());
		System.out.println(rival.getName() + " health: " + rival.getHealth());
	}
	
	private int getTotalDamage() {
		if(weapon != null) {
			return getDamage() + weapon.getDamage();
		} else {
			return getDamage();
		}
	}
}
