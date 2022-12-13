package com.uchennaamadasun.househunter.controllers;

import java.text.SimpleDateFormat;
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

import com.uchennaamadasun.househunter.models.LoginUser;
import com.uchennaamadasun.househunter.models.User;
import com.uchennaamadasun.househunter.services.ListingService;
import com.uchennaamadasun.househunter.services.UserService;

@Controller
public class UserController {
	 @Autowired 
	 private ListingService listingService;
	
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
		Optional<User> thisUser = userService.findUserById((Long) session.getAttribute("userId"));
		User user = thisUser.get();
		model.addAttribute("allListings", listingService.allListings());
		model.addAttribute("user", user);
		  
		
		return "dashboard.jsp";
	}
	
	@GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }

}
