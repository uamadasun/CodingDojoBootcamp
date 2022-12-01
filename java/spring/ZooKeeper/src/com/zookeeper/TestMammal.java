package com.zookeeper;

public class TestMammal {

	public static void main(String[] args) {
		//new  Mammal instance
		Mammal newMammal = new Mammal();
//		newMammal.displayEnergy();
		
		//new Gorilla instance
		Gorilla newGorilla = new Gorilla();
		
		//GORILLA Test methods
		newGorilla.displayEnergy();
		newGorilla.throwSomething();
		newGorilla.throwSomething();
		newGorilla.throwSomething();
		newGorilla.eatBananas();
		newGorilla.eatBananas();
		newGorilla.climb();
		
		//New Bat Instance
		Bat newBat = new Bat();
		
		//Bat Test methods
		newBat.attackTown();
		newBat.attackTown();
		newBat.attackTown();
		newBat.displayEnergy();

		newBat.eatHumans();
		newBat.eatHumans();
		newBat.displayEnergy();
		
		newBat.fly();
		newBat.fly();
		newBat.displayEnergy();
	}
}
