package com.zookeeper;

public class Mammal {
	protected int energyLevel;
	
	public Mammal(){
		this.energyLevel = 100;
	}
	
	public Mammal(int energyLevel){
		this.energyLevel = energyLevel;
	}
	
	public int displayEnergy() {
		System.out.printf("Energy level: %d.\n", this.energyLevel);
		return this.energyLevel;
	}
	
	public void printMessage(String message) {
		System.out.println(message);
	}

}
