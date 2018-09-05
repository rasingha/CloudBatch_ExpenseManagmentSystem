package com.cg.expense.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.cg.expense.entity.ExpenseDetail;
import com.cg.expense.exception.ExpenseNotFoundException;
import com.cg.expense.repository.IExpenseDetailRepository;

@Service
@Transactional
public class ExpenseDetailServiceImpl implements IExpenseDetailService{

	@Autowired
	IExpenseDetailRepository expenseDetailRepository;
	
	@Override
	public ExpenseDetail getEmployeeDetailsById(long claimId)throws ExpenseNotFoundException {
		
		
		if(!expenseDetailRepository.findById(claimId).isPresent())
			return null;
		else
			
		return expenseDetailRepository.findById(claimId).get();
	}
	
	@Override
	public List<ExpenseDetail> getEmployeeDetailsByEmpId(long empId)throws ExpenseNotFoundException {
//		
//		
//		List<ExpenseDetail> explist= expenseDetailRepository.getEmployeeDetailsByEmpId(empId);
//		System.out.println(explist);
		return null;
//		
	}

	@Override
	public void createExpense(ExpenseDetail expense) {
		// TODO Auto-generated method stub
		expenseDetailRepository.save(expense);
	}

	@Override
	public void updateExpense(ExpenseDetail expense) {
		// TODO Auto-generated method stub
		expenseDetailRepository.save(expense);
	}

	@Override
	public void deleteExpense(Long claimId) {
		// TODO Auto-generated method stub
		expenseDetailRepository.deleteById(claimId);
	}

	@Override
	public List<ExpenseDetail> getAllExpenseDeatils() {
		// TODO Auto-generated method stub
		return expenseDetailRepository.findAll();
	}

}
