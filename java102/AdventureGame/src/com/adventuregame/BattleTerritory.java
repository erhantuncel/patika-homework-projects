package com.adventuregame;

import java.util.SplittableRandom;

public class BattleTerritory extends Territory {

	private Monster monster;
	
	private int monsterCount;
	
	private int maxMonsterCount;
	
	private Item item;
	
	public BattleTerritory(int id, String name, Monster monster, int maxMonsterCount, Item item) {
		super(id, name);
		this.maxMonsterCount = maxMonsterCount;
		this.item = item;
		this.monster = new Monster(
				monster.getId(), 
				monster.getName(), 
				monster.getDamage(), 
				monster.getHealth(), 
				monster.getMoney()
				);
	}

	public Monster getMonster() {
		return monster;
	}

	public void setMonster(Monster monster) {
		this.monster = monster;
	}

	public int getMonsterCount() {
		return monsterCount;
	}

	public void setMonsterCount(int monsterCount) {
		this.monsterCount = monsterCount;
	}

	public int getMaxMonsterCount() {
		return maxMonsterCount;
	}

	public void setMaxMonsterCount(int maxMonsterCount) {
		this.maxMonsterCount = maxMonsterCount;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		String award = "";
		if(getItem() != null) {
			award = getItem().getName();
		} else {
			award = "Weapon/Armor/Money";
		}
		
		return super.toString() + "\t" + getMonster().getName() + "(1-" + getMaxMonsterCount() + ")" 
								+ "\tAward: " + award;
	}

	public boolean battle() {
		for(int i=0; i<getMonsterCount(); i++) {
			Monster monsterToFight = new Monster(
					getMonster().getId(), 
					getMonster().getName(), 
					getMonster().getDamage(), 
					getMonster().getHealth(), 
					getMonster().getMoney()
					);
			Helper.printPlayerInfo(getPlayer());
			System.out.println(monsterToFight);
			
			boolean isMonsterHitFirst = Helper.generateTrueWithProbability(50);
			if(isMonsterHitFirst) {
				System.out.println("Who First : " + monsterToFight.getName());
				System.out.print(monsterToFight.getName() + " hit! -> ");
				monsterToFight.hit(getPlayer().getWarrior());				
			} else {				
				System.out.println("Who First : " + getPlayer().getWarrior().getName());
			}
			
			while(getPlayer().getWarrior().getHealth() > 0 && monsterToFight.getHealth() > 0) {
				System.out.println("\nHit or Excape H/E: ");
				String hitOrExcape = Helper.INPUT.next().toUpperCase();
				if(hitOrExcape.equals("H")) {
					System.out.print(getPlayer().getWarrior().getName() + " hit! -> ");
					getPlayer().getWarrior().hit(monsterToFight);
					if(monsterToFight.getHealth() > 0) {						
						System.out.print(monsterToFight.getName() + " hit! -> ");
						monsterToFight.hit(getPlayer().getWarrior());
					}
				} else {
					return false;
				}
			}
			
			if(monsterToFight.getHealth() < getPlayer().getWarrior().getHealth()) {
				Helper.printLogMessage("You defeated the monster.");
				getPlayer().getWarrior().setMoney(getPlayer().getWarrior().getMoney() + monsterToFight.getMoney());
				Helper.printLogMessage("Money won: " + monsterToFight.getMoney());
			}
		}
		giveAward();
		
		return false;
	}

	private void giveAward() {
		Award[] playerAwards = getPlayer().getAwards();
		Award[] updatedAward = new Award[playerAwards.length + 1];
		for(int i=0; i<playerAwards.length; i++) {
			updatedAward[i] = playerAwards[i];
		}
		updatedAward[playerAwards.length] = (Award) getItem();
		getPlayer().setAwards(updatedAward);
		Helper.printLogMessage("Award won: " + getItem().getName());
	}

	@Override
	public boolean onTerritory(Player player) {
		for(Award award : player.getAwards()) {
			if(award.getName().equals(getItem().getName())) {
				Helper.printLogMessage("You have already had " + getItem().getName());
				return true;
			}
		}
		setPlayer(player);
		setMonsterCount(Helper.generateRandomNumberBetween(1, maxMonsterCount));
		System.out.println("You are here: " + getName() + " " + getMonsterCount() + " " + getMonster().getName());
		if(getMonster().getName().equals(Helper.MONSTERS[3].getName())) {
			getMonster().setDamage(Helper.generateRandomNumberBetween(3, 6));
		}
		System.out.print("Fight or Excape F/E: ");
		String selectedState = Helper.INPUT.next().toUpperCase();
		if(selectedState.equals("F")) {
			battle();
		}
		return true;
	}
}
