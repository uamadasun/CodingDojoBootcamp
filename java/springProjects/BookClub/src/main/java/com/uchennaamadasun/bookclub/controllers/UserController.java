package com.uchennaamadasun.bookclub.controllers;

import java.util.ArrayList;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.uchennaamadasun.bookclub.models.Book;
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
	
	@GetMapping("/bookmarket")
	public String bookMarket(Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
		Optional<User> thisUser = userService.findUserById((Long) session.getAttribute("userId"));
		model.addAttribute("user", thisUser.get());
		
		model.addAttribute("bookList", userService.listNoneBorrowedBooks(thisUser.get().getId()));
		
		return "bookMarket.jsp";
	}
	
	
	@DeleteMapping("/borrow/{id}")
	public String borrowBook(@PathVariable("id") Long bookId, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
		userService.borrowBook((Long) session.getAttribute("userId"), bookId);
		model.addAttribute("bookList", userService.listNoneBorrowedBooks((Long) session.getAttribute("userId")));
		Optional<User> thisUser = userService.findUserById((Long) session.getAttribute("userId"));
		model.addAttribute("user", thisUser.get());
		
		return "bookMarket.jsp";
	}
	
	@DeleteMapping("/return/{id}")
	public String returnBook(@PathVariable("id") Long bookId, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
		
		userService.returnBook((Long) session.getAttribute("userId"), bookId);
		
		
		model.addAttribute("bookList", userService.listNoneBorrowedBooks((Long) session.getAttribute("userId")));
		Optional<User> thisUser = userService.findUserById((Long) session.getAttribute("userId"));
		model.addAttribute("user", thisUser.get());
		return "bookMarket.jsp";
		
	}
	
	
	@GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }
	

}
