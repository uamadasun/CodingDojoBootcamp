package com.uchennaamadasun.projectmanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uchennaamadasun.projectmanager.models.Project;
import com.uchennaamadasun.projectmanager.models.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long>{
	List<Task> findAll();
	List<Task> findAllByProject(Project project);

}
