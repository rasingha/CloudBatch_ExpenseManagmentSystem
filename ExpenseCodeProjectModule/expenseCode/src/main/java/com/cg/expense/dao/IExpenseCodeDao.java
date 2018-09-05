package com.cg.expense.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.expense.entity.ExpenseCode;

/************************************************************************************
 * File:  	IExpenseCodeDao.java
 * Package:  com.cg.expense.dao
 * Desc: 	 Dao Interface for the Module: Expense Code
 * Version:  1.0
 * Modifications: -
 * Author: Ranjith Vallambhatla   Date:  29-August-2018   Change Description: -
 ************************************************************************************/
public interface IExpenseCodeDao extends JpaRepository<ExpenseCode, Integer>{

}
