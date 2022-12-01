package com.newcafejava;

public class TestOrder {

	public static void main(String[] args) {
	    
        // Menu items
		Item item1 = new Item("mocha", 3);
		Item item2 = new Item("latte", 2.75);
		Item item3 = new Item("drip coffee", 1.5);
		Item item4 = new Item("capuccino", 2);
    
        // Order variables -- order1, order2 etc.
		Order order1 = new Order("Chindhuri");
		Order order2 = new Order("Jimmy");
		Order order3 = new Order("Noah");
		Order order4 = new Order("Sam");
    
        // Application Simulations
		order2.addItemToOrder(item1);
		order3.addItemToOrder(item4);
		order4.addItemToOrder(item2);
		order1.ready = true;
		order4.addItemToOrder(item2);
		order4.addItemToOrder(item2);
		order2.ready = true;

        // Use this example code to test various orders' updates
        System.out.printf("Name: %s\n", order4.name);
        System.out.printf("Total: %s\n", order4.total);
        System.out.printf("Ready: %s\n", order4.ready);
        System.out.printf("Items: %s\n", order4.items);
	}

}
