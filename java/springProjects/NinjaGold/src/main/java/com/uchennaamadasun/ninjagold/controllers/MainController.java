package com.uchennaamadasun.ninjagold.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String home(HttpSession session) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		return "index.jsp";
	}
	
	@PostMapping("/gold")
	public String getGold(
			@RequestParam("location") String location,
			HttpSession session) {
		Integer currentCount = (Integer) session.getAttribute("count");
		if (location.equals("farm")) {
			currentCount += 5;
		}
		else if (location.equals("cave")) {
			currentCount += 10;
		}
		else if (location.equals("house")) {
			currentCount += 20;
		}
		else {
			currentCount += 30;
		}
		
		session.setAttribute("count", currentCount);
		
		return "redirect:/";
	}
	

}
