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
import org.springframework.web.bind.annotation.RequestParam;

import com.uchennaamadasun.products.models.Category;
import com.uchennaamadasun.products.models.Product;
import com.uchennaamadasun.products.services.CategoryService;
import com.uchennaamadasun.products.services.ProductService;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/")
	public String homePage(Model model) {
		model.addAttribute("allProducts", productService.allProducts());
		model.addAttribute("allCategories", categoryService.allCategories());
		return "index.jsp";
	}
	
	@GetMapping("/category/new")
	public String newCategoryPage(@ModelAttribute("newCategory") Category category) {
		return "newCategoryForm.jsp";
	}
	
	@PostMapping("/category/new")
	public String newCategory(@Valid @ModelAttribute("newCategory") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "newCategoryForm.jsp";
		}
		categoryService.createCategory(category);
		return "redirect:/";
	}
	
	@GetMapping("/view/{id}/category")
	public String viewOneCategory(@PathVariable("id") Long id, Model model) {
		Category category = categoryService.findOneCategory(id);
		model.addAttribute("category", category);
		model.addAttribute("productsInCategory", categoryService.findAllProductsInThisCategory(category));
		model.addAttribute("productsNotInCategory", categoryService.findProductsNotInThisCategory(category));
		return "viewOneCategory.jsp";	
	}
	
	
	
	@PostMapping("/join/{id}/category")
	public String addCategoryToProduct(@PathVariable("id") Long categoryId, @RequestParam("product") Long productId, Model model) {
		Product thisProduct = productService.findOneProduct(productId);
		Category thisCategory =  categoryService.findOneCategory(categoryId);
		model.addAttribute("category", categoryService.findOneCategory(categoryId));
		model.addAttribute("productsInCategory", categoryService.findAllProductsInThisCategory(thisCategory));
		model.addAttribute("productsNotInCategory", categoryService.findProductsNotInThisCategory(thisCategory));
		
		productService.addProductToACategory(thisProduct.getId(), thisCategory.getId());
		return "redirect:/view/{id}/category";
	}
	
	

}
