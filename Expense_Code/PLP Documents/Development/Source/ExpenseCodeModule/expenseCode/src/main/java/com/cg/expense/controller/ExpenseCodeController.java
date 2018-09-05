package com.cg.expense.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
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

/************************************************************************************
 * File:  	 ExpenseCodeController.java
 * Package:  com.cg.expense.controller
 * Desc: 	 Controller for the Module: Expense Code
 * Version:  1.0
 * Modifications: -
 * Author: Ranjith Vallambhatla   Date:  29-August-2018   Change Description: -
 ************************************************************************************/
@RefreshScope
@RestController
public class ExpenseCodeController
{
	static final Logger logger=Logger.getRootLogger();
	public ExpenseCodeController()
	{
	   PropertyConfigurator.configure("Resources/log4j.properties");
	}
	
	

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
	
	
	@PostMapping("/")
	public void createExpenseCode(@Valid @RequestBody ExpenseCode expenseCode, BindingResult result )
	{
		if(!result.hasErrors())
		{
			expenseCheck=1;
			ExpenseCode exp=expenseCodeService.save(expenseCode);
			if(expenseCheck==0)
			{	logger.error("field already exists");
				throw new ExpenseNotFoundException("Field already exists "+exp.getExpenseCode());
			}
		}
		else
		{
			logger.error(result.getFieldError().getDefaultMessage());			
			throw new ExpenseNotFoundException(result.getFieldError().getDefaultMessage());
		}
	
	}
	@GetMapping("/")
	public List<ExpenseCode> getAllExpenses()
	{
		return expenseCodeService.getAllExpenses();
	}
	
	@GetMapping("/{expenseCode}")
	
	public ExpenseCode getExpense( @PathVariable Integer expenseCode)
	{
		ExpenseCode exp=expenseCodeService.getExpense(expenseCode);
			if(exp==null)
			{	
				logger.error("Wrong Expense Code");
				throw new ExpenseNotFoundException("Wrong Expense Code : "+expenseCode);
			}
			else
			{
				return exp;
			}
	}
	
		
	@PutMapping("/")
	public void updateExpense(@Valid @RequestBody ExpenseCode expenseCode, BindingResult result)
	{
		if (!result.hasErrors())
		{
			expenseCheck = 1;
			ExpenseCode exp = expenseCodeService.update(expenseCode);
			if (expenseCheck == 0)
			{
				logger.error("Field already exists");
				throw new ExpenseNotFoundException("Field already exists " + exp.getExpenseCode());
			} 
		}
		else
		{
			logger.error(result.getFieldError().getDefaultMessage());
			throw new ExpenseNotFoundException(result.getFieldError().getDefaultMessage());
		}
	}
	
	@DeleteMapping("/{expenseCode}")
	public void deleteCustomer(@PathVariable Integer expenseCode) {
		
		Integer exp=expenseCodeService.delete(expenseCode);
		if(exp==0)
		{
			logger.error("Wrong Expense Code");
			throw new ExpenseNotFoundException("Wrong Expense Code : "+expenseCode);
		}
		
	}
	
}