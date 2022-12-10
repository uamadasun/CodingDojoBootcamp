package com.uchennaamadasun.bookclub.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.uchennaamadasun.bookclub.models.LoginUser;
import com.uchennaamadasun.bookclub.models.User;
import com.uchennaamadasun.bookclub.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	
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
	
	

}
