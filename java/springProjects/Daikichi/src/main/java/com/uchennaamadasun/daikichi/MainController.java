package com.uchennaamadasun.daikichi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class MainController {
	
	@RequestMapping("")
	public String welcomeMessage() {
		return "Welcome!";
	}
	
	@RequestMapping("/today")
	public String todayMessage() {
		return "Today you will find luck in all your endeavors!";
	}
	
	@RequestMapping("/tomorrow")
	public String tomorrowMessage() {
		return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas";
	}
	

}
