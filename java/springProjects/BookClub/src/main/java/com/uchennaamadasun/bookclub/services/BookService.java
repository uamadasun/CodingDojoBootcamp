package com.uchennaamadasun.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uchennaamadasun.bookclub.models.Book;
import com.uchennaamadasun.bookclub.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	//FIND ALL BOOKS
	public List<Book> allBooks() {
		return bookRepository.findAll();
	}
	
	//CREATE A BOOK
	public Book createBook(Book book) {
		return bookRepository.save(book);
	}
	
	//VIEW ONE BOOK
	public Book viewOne(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		}
		
		return null;
	}
	
	//UPDATE A BOOK
	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}
	
	//DELETE A BOOK 
	public void deleteBook(Long id) {
		this.bookRepository.deleteById(id);
		return;
	}
	

}
