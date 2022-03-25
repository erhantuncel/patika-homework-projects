package com.adventuregame;

public class Monster extends Rival {

	public Monster(int id, String name, int damage, int health, int money) {
		super(id, name, damage, health, money);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void hit(Rival rival) {
		int totalDamage = getDamage();
		Warrior warrior = (Warrior) rival;
		if(warrior.getArmor() != null) {
			totalDamage = totalDamage - warrior.getArmor().getProtection();
			if(totalDamage < 0) {
				totalDamage = 0;
			}
		}
		rival.setHealth(rival.getHealth() - totalDamage);
		System.out.println(rival.getName() + " health: " + rival.getHealth());
	}

	@Override
	public String toString() {
		return getName() + "\tDamage: " + getDamage() + "\tHealth: " + getHealth() + "\tMoney: " + getMoney();
	}
}
