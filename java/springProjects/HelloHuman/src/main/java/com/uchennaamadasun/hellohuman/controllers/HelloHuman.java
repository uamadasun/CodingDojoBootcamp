package com.uchennaamadasun.hellohuman.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloHuman {
	
	@RequestMapping("/")
	public String index(@RequestParam(value="name", required=false) String firstName, 
			@RequestParam(value="last_name", required=false) String lastName, @RequestParam(value="times", required=false) Integer times ) {
		if(firstName == null) {
			return "Hello Human";
		}
		
//		return "Hello " + firstName + " " + lastName;
		
		String message = "";
		for (int i=0; i<=times; i++) {
			message = message + " " + ("Hello" + " " + firstName);
		}
		return message;
	}
	

}
