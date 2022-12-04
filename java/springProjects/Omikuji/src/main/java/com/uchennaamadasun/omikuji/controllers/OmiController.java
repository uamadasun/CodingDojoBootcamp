package com.uchennaamadasun.omikuji.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/omikuji")
public class OmiController {
	
	@GetMapping("")
	public String home() {
		return "omiform.jsp";
	}
	
	@PostMapping("/new")
	public String newOmi(
			@RequestParam(value="number", required=false) Integer number,
			@RequestParam(value="city", required=false) String city,
			@RequestParam(value="person", required=false) String person,
			@RequestParam(value="hobby", required=false) String hobby,
			@RequestParam(value="thing", required=false) String thing,
			@RequestParam(value="message", required=false) String message, HttpSession session) {
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("hobby", hobby);
		session.setAttribute("thing", thing);
		session.setAttribute("message", message);
		
		return "redirect:/omikuji/show";
	}
	
	@GetMapping("/show")
	public String showOmi(Model model, HttpSession session) {
		
		Integer number = (Integer) session.getAttribute("number");
		String city = (String) session.getAttribute("city");
		String person = (String) session.getAttribute("person");
		String hobby = (String) session.getAttribute("hobby");
		String thing = (String) session.getAttribute("thing");
		String message = (String) session.getAttribute("message");
		
		model.addAttribute("number", number);
		model.addAttribute("city", city);
		model.addAttribute("person", person);
		model.addAttribute("hobby", hobby);
		model.addAttribute("thing", thing);
		model.addAttribute("message", message);


		return "showomi.jsp";
	}

}
