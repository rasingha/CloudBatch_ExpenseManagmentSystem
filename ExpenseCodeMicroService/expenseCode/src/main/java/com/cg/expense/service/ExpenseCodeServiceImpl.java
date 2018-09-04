package com.cg.expense.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.expense.controller.ExpenseCodeController;
import com.cg.expense.dao.IExpenseCodeDao;
import com.cg.expense.entity.ExpenseCode;

@Service
public class ExpenseCodeServiceImpl implements IExpenseCodeService{

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
					return expense;
				}
			}
		}
		
	 		return expenseCodeDao.save(expenseCode);	 	
	}

	@Transactional
	public List<ExpenseCode> getAllExpenses() {
		List<ExpenseCode> expenseCode = new ArrayList<>();
		for (ExpenseCode expense : expenseCodeDao.findAll()) {
			expenseCode.add(expense);
		}
		return expenseCode;
	}

	@Transactional
	public ExpenseCode getExpense(Integer expenseCode) {
		if(expenseCodeDao.findById(expenseCode).isPresent())
		return expenseCodeDao.findById(expenseCode).get();
		else
		{
			return null;
		}
	}

	@Transactional
	public ExpenseCode update(ExpenseCode expenseCode) {
		List<ExpenseCode> expenseC = new ArrayList<ExpenseCode>();
		expenseC=expenseCodeDao.findAll();
		if(!expenseC.isEmpty()) {
		for (ExpenseCode expense : expenseC) {
			if(expense.getExpenseType().equalsIgnoreCase(expenseCode.getExpenseType())) {
				if(expense.getExpenseCode()==expenseCode.getExpenseCode()) {
					return expenseCodeDao.save(expenseCode);
				}
				else {
					exp.setExpenseCheck(0);
					return expense;
					}
				}
			}
		}
		
	 		return expenseCodeDao.save(expenseCode);	
		
	}


	@Transactional
	public Integer delete(Integer expenseCode) {
		if(expenseCodeDao.findById(expenseCode).isPresent()) {
			expenseCodeDao.deleteById(expenseCode);
			return expenseCode;
			}
		
		else return 0;
	}
		 

}
