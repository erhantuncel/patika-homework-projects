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
				if(getPlayer().getWarrior().getHealth() <= 0) {
					return false;
				}
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
				if(monsterToFight.getMoney() != 0) {					
					getPlayer().getWarrior().setMoney(getPlayer().getWarrior().getMoney() + monsterToFight.getMoney());
					Helper.printLogMessage("Money won: " + monsterToFight.getMoney());
				}
			}
		}
		
		if(getItem() != null) {			
			giveAward();
		} else {
			giveToolOrMoney();
		}
		
		return false;
	}

	private void giveToolOrMoney() {
		SplittableRandom random = new SplittableRandom();
		int randomToolNumber = random.nextInt(1, 101);
		if(randomToolNumber <= 15) {
			int randomWeaponNumber = random.nextInt(1, 101);
			Weapon weaponToGive = (Weapon) Helper.selectTool503020Probability(randomWeaponNumber, 
					Helper.WEAPONS[0], 
					Helper.WEAPONS[1], 
					Helper.WEAPONS[2]);
			Weapon warriorWeapon = getPlayer().getWarrior().getWeapon();
			if(warriorWeapon != null && warriorWeapon.getDamage() < weaponToGive.getDamage()) {
				getPlayer().getWarrior().setWeapon(weaponToGive);
				Helper.printLogMessage("Weapon won: " + weaponToGive.getName());
			}
		} else if(randomToolNumber > 15 && randomToolNumber <= 30) {
			int randomArmorNumber = random.nextInt(1, 101);
			Armor armorToGive = (Armor) Helper.selectTool503020Probability(randomArmorNumber, 
					Helper.ARMORS[0],
					Helper.ARMORS[1],
					Helper.ARMORS[2]);
			Armor warriorArmor = getPlayer().getWarrior().getArmor();
			if(warriorArmor != null && warriorArmor.getProtection() < armorToGive.getProtection()) {
				getPlayer().getWarrior().setArmor(armorToGive);
				Helper.printLogMessage("Armor won: " + armorToGive.getName());
			}
		} else if(randomToolNumber > 30 && randomToolNumber <= 55) {
			int randomMoneyNumber = random.nextInt(1, 101);
			int moneyToGive = Helper.selectMoney503020Probability(randomMoneyNumber, 1, 5, 10);
			int warriorMoney = getPlayer().getWarrior().getMoney();
			getPlayer().getWarrior().setMoney(warriorMoney + moneyToGive);
			Helper.printLogMessage("Money won: " + moneyToGive);
		} else if(randomToolNumber > 55 && randomToolNumber <= 100) {
			Helper.printLogMessage("No money or tool won!");
		}
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
		if(getItem() != null) {			
			for(Award award : player.getAwards()) {
				if(award.getName().equals(getItem().getName())) {
					Helper.printLogMessage("You have already had " + getItem().getName());
					return true;
				}
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
