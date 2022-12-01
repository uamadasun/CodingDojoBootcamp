package com.newcafejava;
import java.util.ArrayList;

public class Order {
	public String name;
	public double total;
	public boolean ready;
	public ArrayList<Item> items;
	
	public Order(String name) {
		this.name = name;
		this.items = new ArrayList<Item>();
		
	}
	
	public void addItemToOrder(Item item) {
		this.items.add(item);
		total += item.price;
	}	

}
