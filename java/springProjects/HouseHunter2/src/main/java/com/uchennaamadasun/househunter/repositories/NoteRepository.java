package com.uchennaamadasun.househunter.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uchennaamadasun.househunter.models.Listing;
import com.uchennaamadasun.househunter.models.Note;

@Repository
public interface NoteRepository extends CrudRepository<Note, Long>{
	List<Note> findAll();
	List<Note> findAllByListing(Listing listing);
	List<Note> findById(Note note);

}
