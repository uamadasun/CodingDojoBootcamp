package com.projectone;

public class HelloWorld {
	public String name;
	
	public HelloWorld(String name){
		this.name = name;
	}
	
	public String greet() {
		return "Hello " + this.name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
