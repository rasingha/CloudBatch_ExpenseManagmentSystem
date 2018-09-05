package com.cg.expense.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.expense.controller.ExpenseCodeController;
import com.cg.expense.dao.IExpenseCodeDao;
import com.cg.expense.entity.ExpenseCode;

/************************************************************************************
 * File:  	 ExpenseCodeServiceImpl.java
 * Package:  com.cg.expense.service
 * Desc: 	 Service for the Module: Expense Code
 * Version:  1.0
 * Modifications: -
 * Author: Amruta Deokar  Date:  01-September-2018   Change Description: -
 ************************************************************************************/
@Service
public class ExpenseCodeServiceImpl implements IExpenseCodeService{
	
	static final Logger logger=Logger.getRootLogger();
	public ExpenseCodeServiceImpl()
	{
	   PropertyConfigurator.configure("Resources/log4j.properties");
	}
	
	@Autowired
	ExpenseCodeController exp;
	@Autowired
	IExpenseCodeDao expenseCodeDao;

	@Transactional
	public ExpenseCode save(ExpenseCode expenseCode) {
	 	
		List<ExpenseCode> expenseC = new ArrayList<ExpenseCode>();
		expenseC=expenseCodeDao.findAll();
		if(!expenseC.isEmpty()) {
		for (ExpenseCode expense : expenseC) {
			if(expense.getExpenseType().equalsIgnoreCase(expenseCode.getExpenseType())) {
					exp.setExpenseCheck(0);
					logger.info("Expense Type already exists");
					return expense;
				}
			}
		}
			logger.info("Adding the Expense type.");
			 return expenseCodeDao.save(expenseCode);	 	
	}

	@Transactional
	public List<ExpenseCode> getAllExpenses() 
	{
	logger.info("Retrieving all the expense types.");
	return expenseCodeDao.findAll();
	}

	@Transactional
	public ExpenseCode getExpense(Integer expenseCode) {
		if(expenseCodeDao.findById(expenseCode).isPresent())
		{
		logger.info("Retreiving the expense data for expense code:"+expenseCode);
		return expenseCodeDao.findById(expenseCode).get();
		}
		else
		{
			return null;
		}
	}

	@Transactional
	public ExpenseCode update(ExpenseCode expenseCode) {
		List<ExpenseCode> expenseC = new ArrayList<ExpenseCode>();
		expenseC=expenseCodeDao.findAll();
		if(!expenseC.isEmpty())
		{
			for (ExpenseCode expense : expenseC)
			{
				if(expense.getExpenseType().equalsIgnoreCase(expenseCode.getExpenseType()))
				{
					if(expense.getExpenseCode()==expenseCode.getExpenseCode())
					{
						logger.info("Updating expense data for expense id:"+expense.getExpenseCode());
						return expenseCodeDao.save(expenseCode);
					}
					else 
					{
						exp.setExpenseCheck(0);
						logger.info("No such expense type, cant perform update.");
						return expense;
					}
				}
				
			}
		}
			logger.info("No data for the "+expenseCode+",making a new entry for the code.");
	 		return expenseCodeDao.save(expenseCode);	
		
	}


	@Transactional
	public Integer delete(Integer expenseCode) {
		if(expenseCodeDao.findById(expenseCode).isPresent())
		{
			expenseCodeDao.deleteById(expenseCode);
			logger.info("Deleting data for the expense code"+expenseCode);
			return expenseCode;
		}
		else 
		{
			logger.info("No data for the code"+expenseCode+",cant delete.");
			return 0;
		}
	}
		 

}
