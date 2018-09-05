package com.cg.expense.Expense.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.expense.Expense.bean.Employee;


public interface IEmployeeDao extends JpaRepository<Employee, Long>{

}
