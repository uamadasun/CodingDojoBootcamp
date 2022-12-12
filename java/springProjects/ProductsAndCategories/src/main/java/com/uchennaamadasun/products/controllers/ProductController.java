package com.uchennaamadasun.products.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uchennaamadasun.products.models.Category;
import com.uchennaamadasun.products.models.Product;
import com.uchennaamadasun.products.services.CategoryService;
import com.uchennaamadasun.products.services.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/product/new")
	public String newProductPage(@ModelAttribute("newProduct") Product product) {
		return "newProductForm.jsp";
	}
	
	@PostMapping("/product/new")
	public String newProduct(@Valid @ModelAttribute("newProduct") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "newProductForm.jsp";
		}
		productService.createProduct(product);
		return "redirect:/";
	}
	
	@GetMapping("/view/{id}/product")
	public String viewOneProduct(@PathVariable("id") Long id, Model model, @ModelAttribute("categoryToAdd") Category category) {
		Product product = productService.findOneProduct(id);
		model.addAttribute("product", product);
		model.addAttribute("categories", productService.findAllCategoriesThisProductIsNotIn(product));
		return "viewOneProduct.jsp";	
	}
	
	@PostMapping("/join/{id}/product")
	public String addProductToCategory(@PathVariable("id") Long productId, @RequestParam("category") Long categoryId, Model model) {
		Product thisProduct = productService.findOneProduct(productId);
		Category thisCategory =  categoryService.findOneCategory(categoryId);
		
		model.addAttribute("categories", productService.findAllCategoriesThisProductIsNotIn(thisProduct));
		model.addAttribute("allCategories", categoryService.allCategories());
	
		
		productService.addProductToACategory(thisProduct.getId(), thisCategory.getId());
		
		return "redirect:/view/{id}/product";
	}
	


}
