package com.zookeeper;


public class Gorilla extends Mammal {
	
	//ask about this: do i need to create this empty constructor to be able to take the default for the parent class
	//if argument isn't passed in, i want to take the parent class' default.
	public Gorilla() {
		super();
	}
	
	public Gorilla(int energyLevel) {
		super(energyLevel);
	}
	
	public void throwSomething() {
		this.printMessage("Oh no, this gorilla just threw poop.");
		this.energyLevel -= 5;
		this.displayEnergy();
	}
	
	public void eatBananas() {
		this.printMessage("Yummy, this gorilla just ate a banana.");
		this.energyLevel += 10;
		this.displayEnergy();
	}
	
	public void climb() {
		this.printMessage("Whew! This gorilla just climbed a tree and needs a nap now.");
		this.energyLevel -=10;
		this.displayEnergy();
	}

}
