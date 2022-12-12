package com.uchennaamadasun.products.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uchennaamadasun.products.models.Category;
import com.uchennaamadasun.products.models.Product;
import com.uchennaamadasun.products.repositories.CategoryRepository;
import com.uchennaamadasun.products.repositories.ProductRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;

	
	//FIND ALL CATEGORIES
	public List<Category> allCategories() {
		return categoryRepository.findAll();
	}
	
	//CREATE A CATEGORY
	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	//FIND ONE CATEGORY
	public Category findOneCategory(Long id) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		if (optionalCategory.isPresent()) {
			return optionalCategory.get();
		}
		return null;
	}
	
//	//FIND ALL PRODUCTS IN A PARTICULAR CATEGORY
	public List<Product> findAllProductsInThisCategory(Category category) {
		return productRepository.findAllByCategories(category);
	}
//	
//	//FIND ALL PRODUCTS THAT ARE NOT IN THIS CATEGORY
	public List<Product> findProductsNotInThisCategory(Category category) {
		return productRepository.findByCategoriesNotContains(category);
	}
	

}
