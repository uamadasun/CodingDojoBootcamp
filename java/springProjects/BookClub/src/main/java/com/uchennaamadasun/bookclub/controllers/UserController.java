package com.uchennaamadasun.bookclub.controllers;

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

import com.uchennaamadasun.bookclub.models.LoginUser;
import com.uchennaamadasun.bookclub.models.User;
import com.uchennaamadasun.bookclub.services.BookService;
import com.uchennaamadasun.bookclub.services.UserService;

@Controller
public class UserController {
	@Autowired
	private BookService bookService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String loginPage(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "loginPage.jsp";
	}
	
	@PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        //CALL REGISTER METHOD WITH NEW USER
		User registerUser = userService.register(newUser, result);
		
		//CHECK FOR ERRORS IN RESULT
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "loginPage.jsp";
		}
		
		session.setAttribute("userId", registerUser.getId());
        
    
        return "redirect:/home";
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
        return "redirect:/home";
    }
	
	
	@GetMapping("/home")
    public String dashboard(HttpSession session, Model model) {
    	if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
    	//GET LOGGED IN USER TO DISPLAY THEIR NAME ON THE DASHBOARD
    	Optional<User> user = userService.findUserById((Long) session.getAttribute("userId"));
    	model.addAttribute("user", user.get());
    	
    	//SHOW ALL BOOKS ON DASHBOARD
    	model.addAttribute("allBooks", bookService.allBooks());
    	
    	return "dashboard.jsp";
    }
	
	@GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }
	

}
