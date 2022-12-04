package com.uchennaamadasun.counter.controllers;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String index(HttpSession session, Model model) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 1);
		}
		else {
			Integer currentCount  = (Integer) session.getAttribute("count");
			currentCount += 1;
			session.setAttribute("count", currentCount);
		}
		
		return "index.jsp";
	}
	
	@GetMapping("/counter")
	public String counter(HttpSession session, Model model) {
		Integer currentCount;
		
		if (session.getAttribute("count") != null) {
			currentCount  = (Integer) session.getAttribute("count");
		}
		else {
			currentCount = 0;
		}
		
		model.addAttribute("countToShow", currentCount);
		return "counter.jsp";
	}
	
	@GetMapping("/reset")
	public RedirectView reset(HttpSession session, Model model) {
		RedirectView redirectView = new RedirectView();
		session.removeAttribute("count");
		redirectView.setUrl("http://localhost:8080/counter");
	    
	    return redirectView;
	}
	
}
