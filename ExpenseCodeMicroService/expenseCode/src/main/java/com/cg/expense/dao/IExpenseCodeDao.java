package com.cg.expense.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.expense.entity.ExpenseCode;


public interface IExpenseCodeDao extends JpaRepository<ExpenseCode, Integer>{

}
