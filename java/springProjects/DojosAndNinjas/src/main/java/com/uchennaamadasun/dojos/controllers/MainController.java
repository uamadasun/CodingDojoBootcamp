package com.uchennaamadasun.dojos.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.uchennaamadasun.dojos.models.Dojo;
import com.uchennaamadasun.dojos.models.Ninja;
import com.uchennaamadasun.dojos.services.DojoService;
import com.uchennaamadasun.dojos.services.NinjaService;

@Controller
public class MainController {
	@Autowired
	private DojoService dojoService;
	
	@Autowired
	private NinjaService ninjaService;
	
	@GetMapping("/dojos")
	public String showAllDojos() {
		return "dashboard.jsp";
	}
	
	//SHOW NEW DOJO FORM
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("newDojo") Dojo dojo) {
		return "newDojo.jsp";
	}
	
	//PROCESS NEW DOJO FORM
	@PostMapping("/dojos/new")
	public String newDojo(@Valid @ModelAttribute("newDojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "newDojo.jsp";
		}
		dojoService.createDojo(dojo);
		return "redirect:/dojos";
	}
	
	
	
	
	//SHOW NEW NINJA FORM
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("newNinja") Ninja ninja, Model model) {
		model.addAttribute("allDojos", dojoService.allDojos());
		return "newNinja.jsp";
	}
	
	//PROCESS NEW NINJA FORM
	@PostMapping("/ninjas/new")
	public String newNinja(@Valid @ModelAttribute("newNinja") Ninja ninja, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("allDojos", dojoService.allDojos());
			return "newNinja.jsp";
			
		}
		ninjaService.createNinja(ninja);
		return "redirect:/dojos";
	}
	
	
	//VIEW ONE DOJO WITH ALL THE NINJAS IN THE DOJO
	@GetMapping("/dojos/{dojoId}")
	public String viewOneDojo(@PathVariable("dojoId") Long id, Model model) {
		model.addAttribute("dojo", dojoService.findDojo(id));
//		model.addAttribute("allNinjas", ninjaService.findAllNinjasInOneDojo(id));
		return "viewOneDojo.jsp";
	}
	
	
	

}
