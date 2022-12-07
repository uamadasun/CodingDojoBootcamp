package com.uchennaamadasun.burgertracker.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uchennaamadasun.burgertracker.models.BurgerModel;

@Repository
public interface BurgerRepository extends CrudRepository <BurgerModel, Long>{
	List<BurgerModel> findAll();

}
