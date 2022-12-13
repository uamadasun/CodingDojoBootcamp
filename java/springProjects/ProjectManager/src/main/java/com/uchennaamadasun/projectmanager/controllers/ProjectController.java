package com.uchennaamadasun.projectmanager.controllers;

import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.uchennaamadasun.projectmanager.models.Project;
import com.uchennaamadasun.projectmanager.models.User;
import com.uchennaamadasun.projectmanager.services.ProjectService;
import com.uchennaamadasun.projectmanager.services.UserService;

@Controller
public class ProjectController {
	@Autowired 
	private ProjectService projectService;
	
	@Autowired
	private UserService userService;

	
	@GetMapping("/new/project")
	public String newProject(@ModelAttribute("newProject") Project project, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
		
		model.addAttribute("newProject", new Project());
		Optional<User> user = userService.findUserById((Long) session.getAttribute("userId"));
		model.addAttribute("user", user.get());
		return "newProjectForm.jsp";
	}
	
	@PostMapping("/new/project") 
	public String newProject(@Valid @ModelAttribute("newProject") Project project, 
			BindingResult result, Model model, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		
		if (result.hasErrors()) {
			return "newProjectForm.jsp";
		}
		
		Optional<User> user = userService.findUserById((Long) session.getAttribute("userId"));
		model.addAttribute("user", user);
		projectService.createProject(project);
		return "redirect:/dashboard";
		
	}
	
	@GetMapping("/view/{id}")
	public String viewOneProject(@PathVariable("id") Long projectId, Model model, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		model.addAttribute("project", projectService.viewOne(projectId));
		return "viewOneProject.jsp";
	}

}
