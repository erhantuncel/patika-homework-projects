package com.adventuregame;

public class ApplicationMain {
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to Adventure Game");
		System.out.print("What is your name? ");
		Game game = new Game(new Player(Helper.INPUT.next()));
		game.start();	
		
		Helper.INPUT.close();
		
	}
}
