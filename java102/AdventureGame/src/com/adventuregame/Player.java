package com.adventuregame;

public class Player {

	private String name;
	
	private Warrior warrior;
	
	private Award[] awards;
	
	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Warrior getWarrior() {
		return warrior;
	}

	public void setWarrior(Warrior warrior) {
		this.warrior = warrior;
	}

	public Award[] getAwards() {
		return awards;
	}

	public void setAwards(Award[] awards) {
		this.awards = awards;
	}
	
	public void selectWarrior(Warrior warrior) {
		
		setWarrior(
				new Warrior(warrior.getId(), 
							warrior.getName(), 
							warrior.getDamage(), 
							warrior.getHealth(), 
							warrior.getMoney())
				);
		System.out.println(warrior.getName() + " is selected.");
	}
}
