package com.adventuregame;

public class Home extends SafeTerritory {

	public Home(int id, String name) {
		super(id, name);
	}

	@Override
	public boolean onTerritory(Player player) {
		this.setPlayer(player);
		
		for(Warrior warrior : ApplicationMain.WARRIORS) {
			if(this.getPlayer().getWarrior().getId() == warrior.getId()) {
				this.getPlayer().getWarrior().setHealth(warrior.getHealth());
				System.out.println("You are at home. Health is full.");
			}
		}
		return true;
	}
}
