package com.adventuregame;

public class Warrior extends Rival {

	private Tool weapon;	
	private Tool armor;

	public Warrior(int id, String name, int damage, int health, int money) {
		super(id, name, damage, health, money);
	}

	public Tool getWeapon() {
		return weapon;
	}

	public void setWeapon(Tool weapon) {
		this.weapon = weapon;
	}

	public Tool getArmor() {
		return armor;
	}


	public void setArmor(Tool armor) {
		this.armor = armor;
	}

	
	
	@Override
	public String toString() {
		return this.getName() + 
				"\tDamage: " + this.getDamage() + "\tHealth: " + this.getHealth() + 
				"\tMoney: " + this.getMoney();
	}

	@Override
	public void fight(Rival rival) {
		// TODO Auto-generated method stub
		
	}
	

}
