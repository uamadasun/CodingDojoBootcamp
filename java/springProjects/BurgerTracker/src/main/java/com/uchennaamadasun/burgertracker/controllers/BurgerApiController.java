package com.uchennaamadasun.burgertracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uchennaamadasun.burgertracker.models.BurgerModel;
import com.uchennaamadasun.burgertracker.services.BurgerService;

@RestController
@RequestMapping("/api")
public class BurgerApiController {
	//BRING IN SERVICE CLASS
	@Autowired
	private final BurgerService burgerService;
	
	//CONSTRUCTOR
	public BurgerApiController(BurgerService burgerService) {
		this.burgerService = burgerService;
	}
	
	//GET ALL BURGERS
	@GetMapping("/burgers")
	public List<BurgerModel> index() {
		return burgerService.allBurgers();
	}
	
	//CREATE A NEW BURGER
	@PostMapping("/burgers")
	public BurgerModel create(
			@RequestParam(value="burgerName") String burgerName,
			@RequestParam(value="restaurantName") String restaurantName,
			@RequestParam(value="rating") Integer rating, 
			@RequestParam(value="notes") String notes) {
		BurgerModel burger = new BurgerModel(burgerName, restaurantName, rating, notes);
		return burgerService.createBurger(burger);
		
	}
	
	
	

}
