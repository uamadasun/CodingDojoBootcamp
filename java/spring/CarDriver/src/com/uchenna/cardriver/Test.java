package com.uchenna.cardriver;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car newCar = new Car();
		Driver newDriver = new Driver();
		
//		System.out.println(newCar.getGas());
//		System.out.println(newDriver.getGas());
		
		
		newDriver.drive();
		newDriver.drive();
		newDriver.drive();
		newDriver.drive();
		newDriver.useBooster();
		newDriver.useBooster();
		newDriver.refuel();
		newDriver.refuel();
		newDriver.refuel();
		
	}

}
