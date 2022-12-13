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
import org.springframework.web.bind.annotation.PostMapping;

import com.uchennaamadasun.projectmanager.models.LoginUser;
import com.uchennaamadasun.projectmanager.models.Project;
import com.uchennaamadasun.projectmanager.models.User;
import com.uchennaamadasun.projectmanager.services.ProjectService;
import com.uchennaamadasun.projectmanager.services.UserService;

@Controller
public class UserController {
	@Autowired 
	private ProjectService projectService;
	
	@Autowired
	private UserService userService;
	

	
	@GetMapping("/")
	public String loginPage(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return"loginPage.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser,
			BindingResult result, Model model, HttpSession session) {
		User registerUser = userService.register(newUser, result);
		
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "loginPage.jsp";
		}
		
		session.setAttribute("userId", registerUser.getId());
		return "redirect:/dashboard";
	}
	
	@PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        
    	User loginUser = userService.login(newLogin, result);
    
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "loginPage.jsp";
        }
        
        session.setAttribute("userId", loginUser.getId());
        return "redirect:/dashboard";
    }
	
	
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		model.addAttribute("allProjects", projectService.allProjects());
		return "dashboard.jsp";
	}
	
	@GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }
	
//	@GetMapping("/new/project")
//	public String newProject(@ModelAttribute("newProject") Project project, Model model, HttpSession session) {
//		if(session.getAttribute("userId") == null) {
//    		return "redirect:/";
//    	}
//		
//		model.addAttribute("newProject", new Project());
//		Optional<User> user = userService.findUserById((Long) session.getAttribute("userId"));
//		model.addAttribute("user", user.get());
//		return "newProjectForm.jsp";
//	}
//	
//	@PostMapping("/new/project") 
//	public String newProject(@Valid @ModelAttribute("newProject") Project project, 
//			BindingResult result, Model model, HttpSession session) {
//		if (session.getAttribute("userId") == null) {
//			return "redirect:/";
//		}
//		
//		if (result.hasErrors()) {
//			return "newProjectForm.jsp";
//		}
//		
//		Optional<User> user = userService.findUserById((Long) session.getAttribute("userId"));
//		model.addAttribute("user", user);
//		projectService.createProject(project);
//		return "redirect:/dashboard";
//		
//	}
	
	
	
	

}
