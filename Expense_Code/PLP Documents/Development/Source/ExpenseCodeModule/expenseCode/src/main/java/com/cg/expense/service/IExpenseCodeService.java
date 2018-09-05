package com.cg.expense.service;

import java.util.List;
import com.cg.expense.entity.ExpenseCode;


/************************************************************************************
 * File:  	 IExpenseCodeService.java
 * Package:  com.cg.expense.exception
 * Desc: 	 Service Interface class for the Module: Expense Code
 * Version:  1.0
 * Modifications: -
 * Author: Amruta Deokar   Date:  29-August-2018   Change Description: -
 ************************************************************************************/


public interface IExpenseCodeService {

	ExpenseCode save(ExpenseCode expenseCode);

	List<ExpenseCode> getAllExpenses();

	ExpenseCode getExpense(Integer expenseCode);

	ExpenseCode update(ExpenseCode expenseCode);

	Integer delete(Integer expenseCode);
}
