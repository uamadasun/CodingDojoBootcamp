package com.uchennaamadasun.mvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uchennaamadasun.mvc.models.Book;
import com.uchennaamadasun.mvc.services.BookService;

@Controller
@RequestMapping("/books")
public class BooksController {
	@Autowired
	BookService bookService;
	
	@GetMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "/books/new.jsp";
    }
    @PostMapping("/books")
    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/books/new.jsp";
        } else {
            bookService.createBook(book);
            return "redirect:/books";
        }
    }
	
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
//		System.out.println(allBooks);
		model.addAttribute("allBooks", allBooks);
		return "allBooks.jsp";
		
	}
	
	 @RequestMapping("/books/{id}/edit")
	    public String edit(@PathVariable("id") Long id, Model model) {
	        Book book = bookService.findBook(id);
	        model.addAttribute("book", book);
	        return "/books/edit.jsp";
	    }
	    
//	 @RequestMapping(value="/books/{id}", method=RequestMethod.PUT)
//	 public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
//		 if (result.hasErrors()) {
//			 return "/books/edit.jsp";
//			 } else {
//				 bookService.updateBook(book);
//				 return "redirect:/books";
//	        }
//	    }

}
