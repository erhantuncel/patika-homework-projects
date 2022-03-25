package com.adventuregame;

import java.util.Random;
import java.util.Scanner;
import java.util.SplittableRandom;

public class Helper {

	public static Scanner INPUT = new Scanner(System.in);
	public static final Warrior[] WARRIORS = new Warrior[] {
		new Warrior(1, "Samurai", 5, 21, 15),
		new Warrior(2, "Archer", 7, 18, 20),
		new Warrior(3, "Knight", 8, 24, 5)
	};
	
	public static Monster[] MONSTERS = new Monster[] {
		new Monster(1, "Zombie", 3, 10, 4),
		new Monster(2, "Vampire", 4, 14, 7),
		new Monster(3, "Bear", 7, 20, 12),
		new Monster(4, "Snake", generateRandomNumberBetween(3, 6), 12, 0)
	};
	
	public static final Award[] AWARDS = new Award[] {
		new Award(1, "Food"),
		new Award(2, "Firewood"),
		new Award(3, "Water")
	};
	
	public static final Territory[] TERRITORIES = new Territory[] {
		new Home(1, "Home"),
//		new Cave(1, "Cave", new Monster(1, "Zombie", 3, 10, 4), 1, 3, new Award(1, "Food")),
		new BattleTerritory(1, "Cave", MONSTERS[0], 3, AWARDS[0]),
		new BattleTerritory(2, "Forest", MONSTERS[1], 3, AWARDS[1]),
		new BattleTerritory(3, "River", MONSTERS[2], 3, AWARDS[2]),
		new BattleTerritory(4, "Mine", MONSTERS[3], 5, null),
		new ToolStore(2, "Tool Store")
	};
	
	public static final Weapon[] WEAPONS = new Weapon[] {
		new Weapon(1, "Gun", 2, 25),
		new Weapon(2, "Sword", 3, 35),
		new Weapon(3, "Rifle", 7, 45),
	};
	
	public static final Armor[] ARMORS = new Armor[] {
		new Armor(1, "Light", 1, 15),
		new Armor(2, "Medium", 3, 25),
		new Armor(3, "Heavy", 5, 40),
	};
	
	public static void printPlayerInfo(Player player) {
		String weaponStatus = "Weapon: ";
		String armorStatus = "Armor: ";
		String awardStatus = "Awards: ";
		if(player.getWarrior().getWeapon() != null) {			
			Weapon weapon = (Weapon) player.getWarrior().getWeapon();
			weaponStatus = weaponStatus + weapon.getName() + "\tDamage: " + weapon.getDamage();
		}
		if(player.getWarrior().getArmor() != null) {
			Armor armor = (Armor) player.getWarrior().getArmor();
			armorStatus = armorStatus + armor.getName() + "\tProtection: " + armor.getProtection();
		}
		if(player.getAwards().length > 0) {
			for(Award award : player.getAwards()) {
				awardStatus = awardStatus + " " + award.getName();
			}
		}
		System.out.println();
		System.out.println("=======================================================================");
		System.out.println(player.getName() + " - " + awardStatus);
		System.out.println(player.getWarrior());
		System.out.println(weaponStatus);
		System.out.println(armorStatus);
		System.out.println("=======================================================================");
	}
	
	public static void printLogMessage(String message) {
		System.out.println("\n> " + message);
	}
	
	public static int generateRandomNumberBetween(int start, int end) {
		Random random = new Random();
		return random.nextInt(end - start) + start;
	}
	
	public static boolean generateTrueWithProbability(int probability) {
		SplittableRandom random = new SplittableRandom();
		if(random.nextInt(1, 101) <= probability) {
			return true;
		} else {
			return false;
		}
	}
	
	public static Tool selectTool503020Probability(int randomNumber, Tool tool50, Tool tool30, Tool tool20) {
		Tool tool = null;
		if (randomNumber <= 50) {
			tool = tool50;
		} else if (randomNumber > 50 && randomNumber <= 80) {
			tool = tool30;
		} else if (randomNumber > 80 && randomNumber <= 100) {
			tool = tool20;
		}
		return tool;
	}
	
	public static int selectMoney503020Probability(int randomNumber, int money50, int money30, int money20) {
		int money = 0;
		if (randomNumber <= 50) {
			money = money50;
		} else if (randomNumber > 50 && randomNumber <= 80) {
			money = money30;
		} else if (randomNumber > 80 && randomNumber <= 100) {
			money = money20;
		}
		return money;
	}
}
