package com.uchennaamadasun.bookclub.controllers;

import java.util.List;
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
import org.springframework.web.bind.annotation.PutMapping;

import com.uchennaamadasun.bookclub.models.Book;
import com.uchennaamadasun.bookclub.models.User;
import com.uchennaamadasun.bookclub.services.BookService;
import com.uchennaamadasun.bookclub.services.UserService;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/books/new")
	public String newBook (Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
		
		model.addAttribute("newBook", new Book());
		Optional<User> user = userService.findUserById((Long) session.getAttribute("userId"));
		model.addAttribute("user", user.get());
		return "newBookForm.jsp";
	}
	
	@PostMapping("/books/new")
	public String newBook(@Valid @ModelAttribute("newBook") Book book, 
			BindingResult result, Model model, HttpSession session) {
		
		if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
		
		if(result.hasErrors()) {
			return "newBookForm.jsp";
		}
		bookService.createBook(book);
		return "redirect:/home";
	}
	
	@GetMapping("/books/{id}")
	public String viewOneBook(@PathVariable("id") Long id, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
		model.addAttribute("book", bookService.viewOne(id));
		
		return "viewOneBook.jsp";
	}
	
	@GetMapping("/books/{id}/edit")
	public String displayEditPage(@PathVariable("id") Long id, 
			@ModelAttribute("book") Book book, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
		model.addAttribute("book", bookService.viewOne(id));
		return "displayEditPage.jsp";
	}
	
	@PutMapping("/books/{id}/edit")
	public String updateBook(@Valid @ModelAttribute("book") Book book, 
			BindingResult result) {
		if (result.hasErrors()) {
			return "displayEditPage.jsp";
		}
		bookService.updateBook(book);
		return "redirect:/books/{id}";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") Long id) {
		Book thisBook = bookService.viewOne(id);
		for(User user: thisBook.getBorrowingUsers()) {
			List<Book> userBooks = user.getBorrowedBooks();
			userBooks.remove(thisBook);
			user.setBorrowedBooks(userBooks);
		}
		bookService.deleteBook(id);
		return "redirect:/home";
	}
	
	
	
	
	

}
