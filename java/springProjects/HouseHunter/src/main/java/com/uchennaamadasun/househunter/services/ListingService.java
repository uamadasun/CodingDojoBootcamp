package com.uchennaamadasun.househunter.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uchennaamadasun.househunter.models.Listing;
import com.uchennaamadasun.househunter.repositories.ListingRepository;

@Service
public class ListingService {
	
	@Autowired
	private final ListingRepository listingRepository;
	
	
	
	public ListingService(ListingRepository listingRepository) {
		this.listingRepository = listingRepository;
	}

	//FIND ALL LISTINGS
	public List<Listing> allListings() {
		return listingRepository.findAll();
	}
	
	//CREATE A LISTING
	public Listing createListing(Listing listing) {
		return listingRepository.save(listing);
	}
	
	//VIEW ONE LISTING
	public Listing viewOne(Long id) {
		Optional<Listing> optionalListing = listingRepository.findById(id);
		if (optionalListing.isPresent()) {
			return optionalListing.get();
		}
		
		return null;
	}
	
	//UPDATE A LISTING
	public Listing updateListing(Listing listing) {
		return listingRepository.save(listing);
	}
	
	//DELETE A LISTING 
	public void deleteListing(Long id) {
		this.listingRepository.deleteById(id);
		return;
	}

}
