package com.uchennaamadasun.babynames.controllers;

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

import com.uchennaamadasun.babynames.models.BabyName;
import com.uchennaamadasun.babynames.models.User;
import com.uchennaamadasun.babynames.services.BabyNameService;
import com.uchennaamadasun.babynames.services.UserService;

@Controller
public class BabyNameController {
	@Autowired
	private BabyNameService babyNameService;
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/names/new")
	public String newBabyName (Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
		
		model.addAttribute("newBabyName", new BabyName());
		User user = userService.findUserById((Long) session.getAttribute("userId"));
		model.addAttribute("user", user);
		return "newBabyNameForm.jsp";
	}
	
	@PostMapping("/names/new")
	public String newBabyName(@Valid @ModelAttribute("newBabyName") BabyName babyName, 
			BindingResult result, Model model, HttpSession session) {
		
		if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
		
		babyNameService.createBabyName(babyName, result);
		if(result.hasErrors()) {
//			model.addAttribute("newBabyName", new BabyName());
			return "newBabyNameForm.jsp";
		}
		
		return "redirect:/dashboard";
	}
	
	@GetMapping("/view/{id}")
	public String viewOneBabyName(@PathVariable("id") Long id, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
		model.addAttribute("user", userService.findUserById((Long) session.getAttribute("userId")));
		model.addAttribute("babyName", babyNameService.viewOne(id));
		// model.addAttribute("allBabyNames", noteService.listingNotes(listingService.viewOne(id)));
//		model.addAttribute("newNote", new Note());
		
		return "viewOneBabyName.jsp";
	}
	
	@PostMapping("/upvote/{id}")
	public String upvoteBabyName(@PathVariable("id") Long babyNameId, HttpSession session, Model model) {
		User thisUser = userService.findUserById((Long) session.getAttribute("userId"));
		BabyName thisBabyName = babyNameService.viewOne(babyNameId);
		babyNameService.upvoteBabyName(babyNameId, (Long) session.getAttribute("userId"));
		model.addAttribute("user", thisUser);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/babyname/{id}/edit")
	public String displayEditPage(@PathVariable("id") Long id, 
			@ModelAttribute("babyName") BabyName babyName, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
		model.addAttribute("babyName", babyNameService.viewOne(id));
		return "editBabyNameForm.jsp";
	}
	
	@PutMapping("/babyname/{id}/edit")
	public String updateBabyName(@Valid @ModelAttribute("updateBabyName") BabyName babyName, 
			BindingResult result, @PathVariable("id") Long id, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("babyName", babyName);
			return "editBabyNameForm.jsp";
		}
//		BabyName thisBabyName = babyNameService.viewOne(id);
		babyNameService.updateBabyName(babyName);
		return "redirect:/view/{id}";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteBabyName(@PathVariable("id") Long id) {
		babyNameService.deleteBabyName(id);
		return "redirect:/dashboard";
	}
	
	
	
	
	
	
	

}
