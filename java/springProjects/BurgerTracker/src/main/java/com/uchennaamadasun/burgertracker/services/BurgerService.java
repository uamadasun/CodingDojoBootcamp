package com.uchennaamadasun.burgertracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uchennaamadasun.burgertracker.models.BurgerModel;
import com.uchennaamadasun.burgertracker.repositories.BurgerRepository;

@Service
public class BurgerService {
	
	@Autowired
	private final BurgerRepository burgerRepository;
	
	public BurgerService(BurgerRepository burgerRepository) {
		this.burgerRepository = burgerRepository;
	}
	
	//RETURN ALL BURGERS
	public List<BurgerModel> allBurgers() {
		return burgerRepository.findAll();
	}
	
	// CREATE A BURGER
    public BurgerModel createBurger(BurgerModel burger) {
        return burgerRepository.save(burger);
    }
    

}
