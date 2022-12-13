package com.uchennaamadasun.projectmanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uchennaamadasun.projectmanager.models.Project;
import com.uchennaamadasun.projectmanager.repositories.ProjectRepository;
import com.uchennaamadasun.projectmanager.repositories.UserRepository;

@Service
public class ProjectService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	//find all projects
	public List<Project> allProjects() {
		return projectRepository.findAll();
	}
	
	//create a project
	public Project createProject(Project project) {
		return projectRepository.save(project);
	}
	
	//view one project
	public Project viewOne(Long id) {
		Optional<Project> optionalProject = projectRepository.findById(id);
		if (optionalProject.isPresent()) {
			return optionalProject.get();
		}
		return null;
	}
	
	//update a project
	public Project updateProject(Project project) {
		return projectRepository.save(project);
	}
	
	//delete a project
	public void deleteProject(Long id) {
		this.projectRepository.deleteById(id);
		return;
	}
	

}
