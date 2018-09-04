package com.cg.expense.expense.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.expense.expense.bean.Employee;


public interface IEmployeeDao extends JpaRepository<Employee, Long>{

}
