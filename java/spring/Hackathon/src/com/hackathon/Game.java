package com.hackathon;

import java.util.ArrayList;

public class Game {
	
	protected Player player1;
	protected Player player2;
	
	public Game(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
	}
	
	public void startGame(ArrayList<Card> deck) {
		
		//have the players draw a card
		this.player1.drawCard(deck);
		System.out.printf("%s's card is: ", player1.playerName);
		player1.playerCard.showCard();
		
		this.player2.drawCard(deck);
		System.out.printf("%s's card is: ", player2.playerName);
		player2.playerCard.showCard();
		
		if (this.player1.playerCard.getRank() > this.player2.playerCard.getRank()) {
			System.out.printf("%s is the winner.\n", player1.playerName);
		}
		else {
			System.out.printf("%s is the winner.\n", player2.playerName);
		}
		
		
		
	}
	

}
