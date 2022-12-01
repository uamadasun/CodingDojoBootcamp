package com.uchenna.cardriver;

public class Driver extends Car {

	public Driver() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	public void drive() {
		if (!this.gameOver()) {
			System.out.println("You drive the car.");
			this.setGas(getGas()-1);
			System.out.printf("Gas remaining: %d/10\n", this.getGas());
			this.gameOver();
		}
		
	}
	
	public Driver useBooster() {
		if (this.getGas() < 3 || this.gameOver()) {
			System.out.println("You don't have enough gas to use a booster.");
			return this;
		}
		
		System.out.println("You used a booster.");
		this.setGas(getGas()-3);
		System.out.printf("Gas remaining: %d/10\n", this.getGas());
		this.gameOver();
		return this;
	}
	
	public Driver refuel() {
		if (this.getGas() > 8) {
			System.out.println("You have enough gas and don't need to refuel.");
			return this;
		}
		else if (this.gameOver()) {
			System.out.println("The game is over, you can't refuel.");
			return this;
		}
		else {
			System.out.println("You refueled.");
			this.setGas(getGas()+ 2);
			System.out.printf("Gas remaining: %d/10\n", this.getGas());
			return this;
		}
		
	}
	
	public boolean gameOver() {
		if(this.getGas() == 0) {
			System.out.println("Game Over!");
			return true;
		}
		return false;
	}

}
