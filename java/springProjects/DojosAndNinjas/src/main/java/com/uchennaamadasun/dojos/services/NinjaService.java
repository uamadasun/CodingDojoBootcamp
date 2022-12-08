package com.uchennaamadasun.dojos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uchennaamadasun.dojos.models.Ninja;
import com.uchennaamadasun.dojos.repositories.NinjaRepository;

@Service
public class NinjaService {
	
	@Autowired
	private final NinjaRepository ninjaRepository;

	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	//CREATE A NINJA
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}
	
	public List<Ninja> findAllNinjasInOneDojo(Long dojoId) {
		List<Ninja> allNinjas = ninjaRepository.findByDojoId(dojoId);
		return allNinjas;
	}
	
	

}
