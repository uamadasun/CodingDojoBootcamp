package com.uchennaamadasun.househunter.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uchennaamadasun.househunter.models.Listing;
import com.uchennaamadasun.househunter.models.Note;
import com.uchennaamadasun.househunter.models.User;
import com.uchennaamadasun.househunter.repositories.ListingRepository;
import com.uchennaamadasun.househunter.repositories.NoteRepository;
import com.uchennaamadasun.househunter.repositories.UserRepository;

@Service
public class NoteService {
	
	@Autowired
	private NoteRepository noteRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ListingRepository listingRepository;
	
	//FIND NOTE BY LISTING ID
	public List<Note> listingNotes(Listing listing) {
		return noteRepository.findAllByListing(listing);
	}

	//CREATE A NOTE
	public Note createNote(Note newNote) {
		
		return noteRepository.save(newNote);
		
		
	}

}
