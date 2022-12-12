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
public class ProductService {
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;
	
	//FIND ALL PRODUCTS
	public List<Product> allProducts() {
		return productRepository.findAll();
	}
	
	//CREATE A PRODUCT
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}
	
	//FIND ONE PRODUCT BY NAME
	public Product findOneProduct(Long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		if (optionalProduct.isPresent()) {
			return optionalProduct.get();
		}
		return null;
	}
	
	//LIST ALL CATEGORIES THIS PRODUCT APPEARS IN
	public List<Category> findAllCategoriesThisProductAppearsIn(Long id) {
		Product thisProduct = this.findOneProduct(id);
		return categoryRepository.findAllByProducts(thisProduct);
	}
	
	//FIND ALL CATEGORIES THIS PRODUCT IS NOT IN
	public List<Category> findAllCategoriesThisProductIsNotIn(Product product) {
		for (Category category:categoryRepository.findByProductsNotContains(product)) {
			System.out.println("Product is not in this category: " + category.getCategoryName());
			
		}
		System.out.println("***********" );
		return categoryRepository.findByProductsNotContains(product);
	}
	
//	ADD A PRODUCT TO A CATEGORY
	public Product addProductToACategory(Long productId, Long categoryId) {
		Product thisProduct= this.findOneProduct(productId);
		
		Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
		Category thisCategory = optionalCategory.get();
		
		thisProduct.getCategories().add(thisCategory);

		return productRepository.save(thisProduct);
	}
	
	

}
