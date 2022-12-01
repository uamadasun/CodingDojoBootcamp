package com.hackathon;

import java.util.Scanner;

public class TestDeck {

	public static void main(String[] args) {
		
		//open scanner and get player names
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter player 1's name: ");
		String username1 = scanner.nextLine();
		Player player1 = new Player(username1);
		
		System.out.println("Enter player 2's name: ");
		String username2 = scanner.nextLine();
		Player player2 = new Player(username2);
		
		
		//create a new deck
		Deck myDeck = new Deck();
		boolean playGame = true;
		
		while (playGame) {
			System.out.println("Would you like to play a game? ");
			
			String startGame = scanner.nextLine();
			if (startGame.equals("y")) {
				Game newGame = new Game(player1, player2);
				newGame.startGame(myDeck.getCards());
			}
			else {
				playGame = false;
			}
			
		}
		scanner.close();
	}
}