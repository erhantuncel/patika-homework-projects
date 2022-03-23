package com.adventuregame;

public abstract class Territory {
	
	private int id;
	private String name;
	private Player player;
	
	
	public Territory(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	@Override
	public String toString() {
		return getName();
	}

	public abstract boolean onTerritory(Player player);
}
