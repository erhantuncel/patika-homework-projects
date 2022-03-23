package com.adventuregame;

public class ToolStore extends SafeTerritory {

	public ToolStore(int id, String name) {
		super(id, name);
	}

	@Override
	public boolean onTerritory(Player player) {
		this.setPlayer(player);
		boolean showMenu = true;
		while(showMenu) {
			ApplicationMain.printPlayerInfo(player);
			System.out.println("1 - Weapons");
			System.out.println("2 - Armors");
			System.out.println("0 - Quit");
			System.out.print("Select Tool: ");
			int selectedMenuIndex = ApplicationMain.INPUT.nextInt();
			switch (selectedMenuIndex) {
			case 1:
				ApplicationMain.printPlayerInfo(player);
				printTools(ApplicationMain.WEAPONS);
				buyTool(ApplicationMain.WEAPONS);
				break;
			case 2:
				ApplicationMain.printPlayerInfo(player);
				printTools(ApplicationMain.ARMORS);
				buyTool(ApplicationMain.ARMORS);
				break;
			case 0:
				showMenu = false;
				return true;
			}
		}
		return true;
	}
	
	
	private void printTools(Tool[] tools) {
		int index = 1;
		for(Tool tool : tools) {
			System.out.println(index + " - " + tool);
			index++;
		}
		System.out.println("0 - Quit");
		System.out.println("--------------------------------------------------------------");
	}
	
	private void buyTool(Tool[] tools) {
		String toolType = null;
		if(tools instanceof Weapon[]) {
			toolType = "Weapon";
		} else if (tools instanceof Armor[]) {
			toolType = "Armor";
		}
		System.out.print("Select  " + toolType + ": ");
		int selectedIndex = ApplicationMain.INPUT.nextInt();
		while(selectedIndex < 0 || selectedIndex > tools.length) {
			if(selectedIndex == 0) {
				return;
			}
			System.out.print("Invalid " + toolType.toLowerCase() + 
					" number. Please select " + toolType.toLowerCase() + ": ");
			selectedIndex = ApplicationMain.INPUT.nextInt();
		}
		
		if (selectedIndex != 0) {			
			Tool tool =  tools[selectedIndex-1];
			
			if(getPlayer().getWarrior().getMoney() < tool.getPrice()) {
				ApplicationMain.printLogMessage("WARNING: There is not enought balance.");
			} else {
				int balance = getPlayer().getWarrior().getMoney() - tool.getPrice();
				getPlayer().getWarrior().setMoney(balance);
				ApplicationMain.printLogMessage("You bought " + tool.getName());
				if(tool instanceof Weapon) {				
					getPlayer().getWarrior().setWeapon(tool);
					getPlayer().getWarrior().setHealth(0);
				} else if(tool instanceof Armor) {
					getPlayer().getWarrior().setArmor(tool);
				}
			}
		}
		
	}
}
