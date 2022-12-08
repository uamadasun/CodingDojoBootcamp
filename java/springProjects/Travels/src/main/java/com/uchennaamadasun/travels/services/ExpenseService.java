package com.uchennaamadasun.travels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uchennaamadasun.travels.models.Expense;
import com.uchennaamadasun.travels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	
	@Autowired
	private final ExpenseRepository expenseRepository;
	
	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}
	
	//RETURN ALL EXPENSES
	public List<Expense> allExpenses() {
		return expenseRepository.findAll();	
	}
	
	//CREATE AN EXPENSE
	public Expense createExpense(Expense expense) {
		return expenseRepository.save(expense);
	}
	
	//FIND ONE EXPENSE
	public Expense findExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepository.findById(id);
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
		}
		return null;
	}
	
	//UPDATE AN EXPENSE
	public Expense updateExpense(Expense expense) {
		return expenseRepository.save(expense);
	}
	
	//DELETE AN EXPENSE
	public void deleteExpense(Long id) {
		this.expenseRepository.deleteById(id);
		return;
	}

}
