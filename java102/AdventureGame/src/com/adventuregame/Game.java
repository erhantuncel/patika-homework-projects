package com.adventuregame;

public class Game {
	
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
		
		ApplicationMain.printLogMessage(getPlayer().getName() +  " game is started.");
		
		showWarriorSelectMenu();
		while (true) {
			ApplicationMain.printPlayerInfo(getPlayer());
			if(!showTerritorySelectMenu()) {
				ApplicationMain.printLogMessage("See you soon!");
				break;
			}
		}
	}
	
	private boolean showTerritorySelectMenu() {
		Territory[] territories = ApplicationMain.TERRITORIES;
		printTerritories(territories);
		System.out.print("Select territory: ");
		int selectedMenuIndex = ApplicationMain.INPUT.nextInt();
		if(selectedMenuIndex == 0) {
			return false;
		}
		while(selectedMenuIndex < 1 || selectedMenuIndex > territories.length) {
			System.out.print("Invalid territory number. Select territory: ");
			selectedMenuIndex = ApplicationMain.INPUT.nextInt();
		}
		return territories[selectedMenuIndex - 1].onTerritory(getPlayer());
	}

	private void showWarriorSelectMenu() {
		Warrior[] warriors = ApplicationMain.WARRIORS;
		printWarriorList(warriors);
		System.out.print("Select warrior: ");
		int selectedMenuIndex = ApplicationMain.INPUT.nextInt();		
		while (selectedMenuIndex < 1 || selectedMenuIndex > warriors.length) {
			ApplicationMain.printLogMessage("Invalid warrior number. Select warrior: ");
			selectedMenuIndex = ApplicationMain.INPUT.nextInt();
		}
		this.player.selectWarrior(warriors[selectedMenuIndex - 1]);
	}
	
	private void printWarriorList(Warrior[] warriors) {
		int index = 1;
		System.out.println();
		for (Warrior warrior : warriors) {
			System.out.println(index + " - " + warrior);
			index++;
		}
		System.out.println("--------------------------------------------------------------");
	}
	
	private void printTerritories(Territory[] territories) {
		int index = 1;
		for(Territory territory : territories) {
			System.out.println(index + " - " + territory);;
			index++;
		}
		System.out.println("0 - Quit");
		System.out.println("--------------------------------------------------------------");
	}
}
