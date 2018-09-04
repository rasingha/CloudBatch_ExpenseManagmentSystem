package com.cg.expense.service;

import java.util.List;

import com.cg.expense.entity.ExpenseCode;

public interface IExpenseCodeService {

	ExpenseCode save(ExpenseCode expenseCode);

	List<ExpenseCode> getAllExpenses();

	ExpenseCode getExpense(Integer expenseCode);

	ExpenseCode update(ExpenseCode expenseCode);

	Integer delete(Integer expenseCode);
}
