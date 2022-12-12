package com.uchennaamadasun.products.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uchennaamadasun.products.models.Category;
import com.uchennaamadasun.products.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long>{
	List<Product> findAll();
	// Retrieves a list of all categories for a particular product
    List<Product> findAllByCategories(Category category);
    
    // Retrieves a list of any categories a particular product
    // does not belong to.
    //WILL GO ON THE PAGE OF THE PRODUCT WHERE YOU CAN ADD THE PRODUCT TO A PARTICULAR CATEGORY
    List<Product> findByCategoriesNotContains(Category category);

}
