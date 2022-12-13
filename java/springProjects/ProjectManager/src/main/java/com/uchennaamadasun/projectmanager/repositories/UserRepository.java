package com.uchennaamadasun.projectmanager.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uchennaamadasun.projectmanager.models.Project;
import com.uchennaamadasun.projectmanager.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	List<User> findAll();
	Optional<User> findByEmail(String email);
//	List<User> findAllByProjects(Project project);
	
	

}
