package com.uchennaamadasun.babynames.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.uchennaamadasun.babynames.models.BabyName;
import com.uchennaamadasun.babynames.models.User;
import com.uchennaamadasun.babynames.repositories.BabyNameRepository;

@Service
public class BabyNameService {
	
	@Autowired
	private  BabyNameRepository babyNameRepository;
	
	@Autowired
	private  UserService userService;
	
	
	
	//FIND ALL BABY NAMES
	public List<BabyName> allBabyNames() {
		return babyNameRepository.findAll();
	}
	
	//CREATE A BABY NAME
	public BabyName createBabyName(BabyName babyName, BindingResult result) {
		//CHECK FOR ERRORS
		Optional<BabyName> optionalBabyName = babyNameRepository.findByBabyName(babyName.getBabyName());
		if(optionalBabyName.isPresent()) {
			result.rejectValue("babyName", "unique", "Baby name already exists.");
			return null;
		}
		
		if(result.hasErrors()) {
    		return null;
    	}
		return babyNameRepository.save(babyName);
	}
	
	

	//VIEW ONE BABY NAME
	public BabyName viewOne(Long id) {
		Optional<BabyName> optionalBabyName = babyNameRepository.findById(id);
		if (optionalBabyName.isPresent()) {
			return optionalBabyName.get();
		}
		
		return null;
	}
	
	//UPDATE A BABY NAME
	public BabyName updateBabyName(BabyName babyName) {
		return babyNameRepository.save(babyName);
	}
	
	//DELETE A BABY NAME 
	public void deleteBabyName(Long id) {
		this.babyNameRepository.deleteById(id);
		return;
	}
	
	//UPVOTE A BABY NAME
	public BabyName upvoteBabyName(Long babyNameId, Long userId) {
		User thisUser = userService.findUserById(userId);
		BabyName thisBabyName = this.viewOne(babyNameId);
		thisBabyName.getUsers().add(thisUser);
		return babyNameRepository.save(thisBabyName);
		
	}
}
