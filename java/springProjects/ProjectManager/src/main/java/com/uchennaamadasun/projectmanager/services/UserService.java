package com.uchennaamadasun.projectmanager.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.uchennaamadasun.projectmanager.models.LoginUser;
import com.uchennaamadasun.projectmanager.models.User;
import com.uchennaamadasun.projectmanager.repositories.ProjectRepository;
import com.uchennaamadasun.projectmanager.repositories.UserRepository;


@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	public Optional<User> findUserById(Long id) {
		return userRepository.findById(id);
	}
	
	public User register(User newUser, BindingResult result) {
		//CHECK FOR ERRORS
		Optional<User> optionalUser = userRepository.findByEmail(newUser.getEmail());
		if(optionalUser.isPresent()) {
			result.rejectValue("email", "unique", "This email is already registered. Try again!");
			
		}
		
		else if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("password", "matches", "Passwords must match.");
		}
		
		if(result.hasErrors()) {
			return null;
		}
		
		//HASH PW AND CREATE USER IF NO ERRORS
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
