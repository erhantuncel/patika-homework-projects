package com.adventuregame;

import java.util.Scanner;

public class Game {

	private Scanner input = new Scanner(System.in);
	
	private Player player;
	
	private Territory territory;
	
	
	public Game(Player player) {
		this.player = player;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Territory getTerritory() {
		return territory;
	}

	public void setTerritory(Territory territory) {
		this.territory = territory;
	}
	
	public void start() {
		
		System.out.println(getPlayer().getName() +  " game is started.\n");
		
		showWarriorSelectMenu();
		
		
		this.input.close();
		
	}

	private void showWarriorSelectMenu() {
		Warrior[] warriors = getWarriroList();
		printWarriorList(warriors);
		System.out.print("Please select warrior: ");
		while (true) {
			int selectedMenuIndex = input.nextInt();
			if(selectedMenuIndex > 1 && selectedMenuIndex < warriors.length+1 ) {			
				this.player.selectWarrior(warriors[selectedMenuIndex - 1]);
				break;
			} else {
				printWarriorList(warriors);
				System.out.print("Invalid warrior number. Please select warrior: ");
				continue;
			}
		}
	}

	private Warrior[] getWarriroList() {
		Warrior[] warriors = new Warrior[] {
				new Warrior(1, "Samurai", 5, 21, 15),
				new Warrior(2, "Archer", 7, 18, 20),
				new Warrior(3, "Knight", 8, 24, 5)
		};
		return warriors;
	}
	
	private void printWarriorList(Warrior[] warriors) {
		int index = 1;
		for (Warrior warrior : warriors) {
			System.out.println(index + " - " + warrior);
			index++;
		}
		System.out.println("--------------------------------------------------------------");
	}
}
