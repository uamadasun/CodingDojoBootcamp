package com.uchennaamadasun.displaydate.controllers;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String homePage() {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String datePage(Model model) {
		Date currentDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("EEEE, 'the' d 'of' MMMM, yyyy");  
	    String strDate= formatter.format(currentDate);  
		
		model.addAttribute("date", strDate);
		
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String timePage(Model model) {
		Date currentTime = new Date();
		SimpleDateFormat timeFormatter = new SimpleDateFormat("H:mm a");
		String timeNow = timeFormatter.format(currentTime);
		
		model.addAttribute("time", timeNow);
		return "time.jsp";
	}
	
}
