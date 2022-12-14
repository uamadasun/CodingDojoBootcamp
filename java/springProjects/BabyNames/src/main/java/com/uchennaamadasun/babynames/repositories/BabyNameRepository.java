package com.uchennaamadasun.babynames.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uchennaamadasun.babynames.models.BabyName;

@Repository
public interface BabyNameRepository extends CrudRepository<BabyName, Long>{
	List<BabyName> findAll();
	Optional<BabyName> findById(Long id);
	Optional<BabyName> findByBabyName(String babyName);

}

