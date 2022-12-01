package com.zookeeper;

public class Bat extends Mammal {
	
	
	public Bat () {
		super(300); //will call the mammal constructor that takes in an int.
	}
	
	public void fly() {
		this.printMessage("Click! Click! The bat is flying away.");
		this.energyLevel -= 50;
	}
	
	public void eatHumans() {
		this.energyLevel += 25;
	}
	
	public void attackTown() {
		this.printMessage("Aah! The town is on fire!");
		this.energyLevel -= 100;
		
	}

}
