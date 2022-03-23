package com.adventuregame;

import java.util.Scanner;

public class ApplicationMain {

	public static Scanner INPUT = new Scanner(System.in);
	public static final Warrior[] WARRIORS = new Warrior[] {
		new Warrior(1, "Samurai", 5, 21, 85),
		new Warrior(2, "Archer", 7, 18, 20),
		new Warrior(3, "Knight", 8, 24, 5)
	};
	
	public static final Territory[] TERRITORIES = new Territory[] {
		new Home(1, "Home"),
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
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to Adventure Game");
		System.out.print("What is your name? ");
		Game game = new Game(new Player(INPUT.next()));
		game.start();	
		
		INPUT.close();
	}
	
	public static void printPlayerInfo(Player player) {
		System.out.println();
		System.out.println("==============================================================");
		System.out.println(player.getName() + " - " + player.getWarrior());
		if(player.getWarrior().getWeapon() != null) {			
			Weapon weapon = (Weapon) player.getWarrior().getWeapon();
			System.out.println("Weapon: " + weapon.getName() + "\tDamage: " + weapon.getDamage());
		}
		if(player.getWarrior().getArmor() != null) {
			Armor armor = (Armor) player.getWarrior().getArmor();
			System.out.println("Armor: " + armor.getName() + "\tProtection: " + armor.getProtection());
		}
		System.out.println("==============================================================");
	}
	
	public static void printLogMessage(String message) {
		System.out.println("\n> " + message);
	}
}
