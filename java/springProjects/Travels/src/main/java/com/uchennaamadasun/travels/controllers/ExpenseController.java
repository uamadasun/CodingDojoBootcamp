package com.uchennaamadasun.travels.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.uchennaamadasun.travels.models.Expense;
import com.uchennaamadasun.travels.services.ExpenseService;

@Controller
public class ExpenseController {
	@Autowired
	ExpenseService expenseService;
	
	@GetMapping("/expenses")
	public String showAll(Model model) {
		model.addAttribute("allExpenses", expenseService.allExpenses());
		model.addAttribute("newExpense", new Expense());
		return "index.jsp";
	}
	
	@PostMapping("/expenses")
	public String addExpense(@Valid @ModelAttribute("newExpense") Expense expense, 
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("allExpenses", expenseService.allExpenses());
			return "index.jsp";
		}
		expenseService.createExpense(expense);
		return "redirect:/expenses";
	}
	
	@GetMapping("/edit/{id}")
	public String displayEditPage(@PathVariable("id") Long id, 
			@ModelAttribute("expense") Expense expense, Model model) {
		model.addAttribute("expense", expenseService.findExpense(id));
		return "displayEditPage.jsp";
	}
	
	@PutMapping("/new/{id}")
	public String updateExpense(@Valid @ModelAttribute("expense") Expense expense, 
			BindingResult result) {
		if (result.hasErrors()) {
			return "displayEditPage.jsp";
		}
		expenseService.updateExpense(expense);
		return "redirect:/expenses";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteExpense(@PathVariable("id") Long id) {
		expenseService.deleteExpense(id);
		return "redirect:/expenses";
	}
	
	@GetMapping("/expenses/viewOne/{id}")
	public String viewOne(@PathVariable("id") Long id, Model model) {
		model.addAttribute("expense", expenseService.findExpense(id));
		return "viewOne.jsp";
	}
	
	
	


}
