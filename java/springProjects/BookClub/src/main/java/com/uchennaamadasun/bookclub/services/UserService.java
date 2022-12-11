package com.uchennaamadasun.bookclub.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.uchennaamadasun.bookclub.models.Book;
import com.uchennaamadasun.bookclub.models.LoginUser;
import com.uchennaamadasun.bookclub.models.User;
import com.uchennaamadasun.bookclub.repositories.BookRepository;
import com.uchennaamadasun.bookclub.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BookRepository bookRepository;

	public Optional<User> findUserById(Long id) {
		return userRepository.findById(id);
	}
	
	
	public User register(User newUser, BindingResult result) {
    	//1. CHECK IF EMAIL IS ALREADY IN THE SYSTEM
    	Optional<User> optionalUser = userRepository.findByEmail(newUser.getEmail());
    	
    	//2. DOES THE ENTERED PASSWORD MATCH THE CONFIRMED PASSWORD?
    	if(optionalUser.isPresent()) {
    		result.rejectValue("email", "unique", "This email is already registered. Try again or log in.");
    	}
    	
    	else if (!newUser.getPassword().equals(newUser.getConfirm())) {
    		result.rejectValue("password", "matches", "Passwords must match.");
    	}
    	if(result.hasErrors()) {
    		return null;
    	}
    	//3. HASH THE PASSWORD AND CREATE A USER IF THE ABOVE ARE TRUE
    	String hashedPassword = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    	newUser.setPassword(hashedPassword);
    	
        return userRepository.save(newUser);
    }
	
	public User login(LoginUser newLoginObject, BindingResult result) {
        //1. CHECK IF A USER WITH THE EMAIL EXISTS IN THE DATABASE
    	Optional<User> optionalUser = userRepository.findByEmail(newLoginObject.getEmail());
    	if(!optionalUser.isPresent()) {
    		result.rejectValue("email", "inSystem", "This email is not registered");
    		return null;
    	}
    	
    	//2. IF EMAIL IS CORRECT, GET THE OPTIONAL USER'S INFO
    	User user = optionalUser.get();

    	//3. CHECK IF THE NEW USER'S PASSWORD PROVIDED MATCHES THE PASSWORD OF THE USER IN THE DATABASE
    	if(!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
    		result.rejectValue("password", "matches", "Invalid Password");
    	}
    	
    	//4. RETURN NULL IF RESULT HAS ERROR
    	if(result.hasErrors()) {
    		return null;
    	}
  
    	//5. OTHERWISE, RETURN THE NEW USER
        return user;
    }
	
	
	public User borrowBook(Long userId, Long bookId) {
		Optional<Book> optionalBook = bookRepository.findById(bookId);
		Book thisBook = optionalBook.get();
		
		Optional<User> optionalUser = userRepository.findById(userId);
		User thisUser = optionalUser.get();
		
		thisUser.getBorrowedBooks().add(thisBook);
		
		return userRepository.save(thisUser);
	}
	
	public ArrayList<Book> listNoneBorrowedBooks(Long id) {
		Optional <User> optionalUser = userRepository.findById(id);
		ArrayList<Book> bookList = new ArrayList<Book>();
		for(Book book:bookRepository.findAll()) {
			if(!book.getBorrowingUsers().contains(optionalUser.get())) {
				bookList.add(book);
			}
		}
		return bookList;
	}
	
	public User returnBook(Long userId, Long bookId) {
		Optional<Book> optionalBook = bookRepository.findById(bookId);
		Book thisBook = optionalBook.get();
		
		Optional<User> optionalUser = userRepository.findById(userId);
		User thisUser = optionalUser.get();
		
		List<Book> borrowedBooks = thisUser.getBorrowedBooks();
		borrowedBooks.remove(thisBook);
		thisUser.setBorrowedBooks(borrowedBooks);
		
		return userRepository.save(thisUser);
	}
	
	

}
