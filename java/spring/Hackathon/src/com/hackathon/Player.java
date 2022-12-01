package com.hackathon;
import java.util.ArrayList;

public class Player {
	//create a player with a name attribute
	//default name is "Player"
	//if no name is passed in, then we it's the computer
	protected String playerName = "Player";
	protected Card playerCard;
	
	public Player(String playerName) {
		this.playerName = playerName;
		this.playerCard = null;
	}
	
	public void drawCard(ArrayList<Card> deck) {
		//generate random number you can use as an index
		int randomNumber = (int) ((Math.random() * (deck.size() - 0)) + 0);
		
		//remove the card at that index from the deck
		this.playerCard = deck.remove(randomNumber);
	}

}
