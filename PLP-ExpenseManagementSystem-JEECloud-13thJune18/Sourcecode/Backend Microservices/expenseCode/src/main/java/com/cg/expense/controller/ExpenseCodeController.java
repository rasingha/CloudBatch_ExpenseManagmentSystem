package com.cg.expense.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.cg.expense.entity.ExpenseCode;
import com.cg.expense.exception.ExpenseNotFoundException;
import com.cg.expense.service.IExpenseCodeService;

@RefreshScope
@RestController
public class ExpenseCodeController {

public int expenseCheck;
	

	public int getExpenseCheck()
	{
		return expenseCheck;
	}
	public void setExpenseCheck(int expenseCheck)
	{
		this.expenseCheck = expenseCheck;
	}

	@Autowired
	IExpenseCodeService expenseCodeService;
	
	
	@PostMapping("/create")
	public void createExpenseCode(@Valid @RequestBody ExpenseCode expenseCode, BindingResult result ) {
		if(!result.hasErrors())
		{
			expenseCheck=1;
			ExpenseCode exp=expenseCodeService.save(expenseCode);
			if(expenseCheck==0)
			{
				throw new ExpenseNotFoundException("Field already exists "+exp.getExpenseCode());
			}
		}
		else
		{
			throw new ExpenseNotFoundException(result.getFieldError().getDefaultMessage());
		}
	
	}
	@GetMapping("/expenses")
	public List<ExpenseCode> getAllExpenses() {
		return expenseCodeService.getAllExpenses();
	}
	
	@GetMapping("/{expenseCode}")
	public ExpenseCode getExpense(@Valid @PathVariable Integer expenseCode) {
	
		
		ExpenseCode exp=expenseCodeService.getExpense(expenseCode);
		if(exp==null)
		{
			throw new ExpenseNotFoundException("Wrong Expense Code : "+expenseCode);
		}
		else
		{
			return exp;
		}
	}
	
	
	
	
	
	@PutMapping("/update")
	public void updateExpense(@Valid @RequestBody ExpenseCode expenseCode, BindingResult result) {
		if (!result.hasErrors())
		{
			expenseCheck = 1;
			ExpenseCode exp = expenseCodeService.update(expenseCode);
			if (expenseCheck == 0) {
				throw new ExpenseNotFoundException("Field already exists " + exp.getExpenseCode());
			} 
		}
		else
		{
			throw new ExpenseNotFoundException(result.getFieldError().getDefaultMessage());
		}
	}
	
	@DeleteMapping("/delete/{expenseCode}")
	public void deleteCustomer(@PathVariable Integer expenseCode) {
		Integer exp=expenseCodeService.delete(expenseCode);
		if(exp==0)
		{
			throw new ExpenseNotFoundException("Wrong Expense Code : "+expenseCode);
		}
		
	}
	
	
}