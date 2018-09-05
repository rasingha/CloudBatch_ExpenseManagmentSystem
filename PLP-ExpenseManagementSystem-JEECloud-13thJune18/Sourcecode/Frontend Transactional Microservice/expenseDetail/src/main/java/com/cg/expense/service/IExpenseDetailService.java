package com.cg.expense.service;

import java.util.List;

import com.cg.expense.entity.ExpenseDetail;
import com.cg.expense.exception.ExpenseNotFoundException;

public interface IExpenseDetailService {

	public ExpenseDetail getEmployeeDetailsById(long claimId);

	public void createExpense(ExpenseDetail expense);

	public void updateExpense(ExpenseDetail expense);

	public void deleteExpense(Long claimId);

	public List<ExpenseDetail> getAllExpenseDeatils();

	List<ExpenseDetail> getEmployeeDetailsByEmpId(long empId) throws ExpenseNotFoundException;
}
