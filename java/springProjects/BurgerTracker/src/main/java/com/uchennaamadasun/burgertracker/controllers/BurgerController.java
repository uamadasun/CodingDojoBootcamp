package com.uchennaamadasun.burgertracker.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.uchennaamadasun.burgertracker.models.BurgerModel;
import com.uchennaamadasun.burgertracker.services.BurgerService;

@Controller
public class BurgerController {
	@Autowired
	BurgerService burgerService;
	
	@GetMapping("/")
	public String showAll(Model model, @ModelAttribute("burger") BurgerModel burger) {
		List<BurgerModel> allBurgers = burgerService.allBurgers();
		model.addAttribute("allBurgers", allBurgers);
		return "index.jsp";
	}
	
	@PostMapping("/")
	public String create(@Valid @ModelAttribute("burger") BurgerModel burger, 
			BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		}
		else {
			burgerService.createBurger(burger);
			return "redirect:/";
		}
	}
	
	@GetMapping("/burgers/edit/{id}")
	public String editPage(@PathVariable("id") Long id, @ModelAttribute("burger") BurgerModel burger, Model model) {
		model.addAttribute("burger", burgerService.findBurger(id));
		return "editPage.jsp";
	}
	
	@PutMapping("/new/{id}")
	public String updateBurger(@Valid @ModelAttribute("burger") BurgerModel burger, BindingResult result) {
		if (result.hasErrors()) {
			return "editPage.jsp";
		}
		else {
			burgerService.updateBurger(burger);
		}
		return "redirect:/";
	}
	
	

}
