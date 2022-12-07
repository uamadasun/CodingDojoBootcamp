package com.uchennaamadasun.burgertracker.services;

import java.util.List;
import java.util.Optional;

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
    
    // FIND ONE BURGER
    public BurgerModel findBurger(Long id) {
        Optional<BurgerModel> optionalBurger = burgerRepository.findById(id);
        if(optionalBurger.isPresent()) {
            return optionalBurger.get();
        } else {
            return null;
        }
    }
    
    public BurgerModel updateBurger(BurgerModel burger) {
    	return burgerRepository.save(burger);
    }
    
    //DELETE A BURGER
    public void deleteBurger(Long id) {
    	this.burgerRepository.deleteById(id);
    	
    	return;
    }
    

}
