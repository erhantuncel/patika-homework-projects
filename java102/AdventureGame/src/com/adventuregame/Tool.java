package com.adventuregame;

public abstract class Tool extends Item {
	private int price;

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
