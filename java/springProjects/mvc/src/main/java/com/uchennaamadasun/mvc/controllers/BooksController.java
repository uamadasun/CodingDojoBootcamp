package com.uchennaamadasun.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uchennaamadasun.mvc.models.Book;
import com.uchennaamadasun.mvc.services.BookService;

@Controller
@RequestMapping("/books")
public class BooksController {
	@Autowired
	BookService bookService;
	
	@GetMapping("/{bookId}")
	public String showOne(Model model, @PathVariable("bookId") Long id) {
//		System.out.println(id);
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
		return "show.jsp";
	}
	
	@GetMapping("")
	public String showAll(Model model) {
		List<Book> allBooks = bookService.allBooks();
		System.out.println(allBooks);
		model.addAttribute("allBooks", allBooks);
		return "allBooks.jsp";
		
	}

}
