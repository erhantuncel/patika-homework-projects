package com.adventuregame;

import java.util.Scanner;

public class ApplicationMain {

	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to Adventure Game");
		System.out.print("What is your name? ");
		Game game = new Game(new Player(input.next()));
		game.start();	
	}
}
