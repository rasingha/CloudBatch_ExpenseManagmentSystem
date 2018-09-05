package com.cg.expense.Expense.service;

import java.util.List;

import com.cg.expense.Expense.bean.Employee;
import com.cg.expense.Expense.exception.EmployeeException;


public interface IEmployeeService {
	public List<Employee> getAllEmployees() throws EmployeeException;
	public void save(Employee Employee) throws EmployeeException;
	public void update(Employee Employee) throws EmployeeException;
	public void delete(Long emp_id) throws EmployeeException;
	public Employee getEmployeeById(Long emp_id) throws EmployeeException;
	

}
