package com.uchennaamadasun.househunter.controllers;

import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.uchennaamadasun.househunter.models.Listing;
import com.uchennaamadasun.househunter.models.User;
import com.uchennaamadasun.househunter.services.ListingService;
import com.uchennaamadasun.househunter.services.UserService;

@Controller
public class ListingController {
	@Autowired
	private ListingService listingService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/listing/new")
	public String newListing (Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
		
		model.addAttribute("newListing", new Listing());
		Optional<User> user = userService.findUserById((Long) session.getAttribute("userId"));
		model.addAttribute("user", user.get());
		return "newListingForm.jsp";
	}
	
	@PostMapping("/listing/new")
	public String newListing(@Valid @ModelAttribute("newListing") Listing listing, 
			BindingResult result, Model model, HttpSession session) {
		
		if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
		
		if(result.hasErrors()) {
			return "newListingForm.jsp";
		}
		listingService.createListing(listing);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/view/{id}")
	public String viewOneListing(@PathVariable("id") Long id, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
		model.addAttribute("listing", listingService.viewOne(id));
		
		return "viewOneListing.jsp";
	}
	
	@GetMapping("/listing/{id}/edit")
	public String displayEditPage(@PathVariable("id") Long id, 
			@ModelAttribute("listing") Listing listing, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
		model.addAttribute("listing", listingService.viewOne(id));
		return "displayEditPage.jsp";
	}
	
	@PutMapping("/listing/{id}/edit")
	public String updateListing(@Valid @ModelAttribute("listing") Listing listing, 
			BindingResult result) {
		if (result.hasErrors()) {
			return "displayEditPage.jsp";
		}
		listingService.updateListing(listing);
		return "redirect:/dashboard";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteListing(@PathVariable("id") Long id) {
		listingService.deleteListing(id);
		return "redirect:/dashboard";
	}
	
	

}
