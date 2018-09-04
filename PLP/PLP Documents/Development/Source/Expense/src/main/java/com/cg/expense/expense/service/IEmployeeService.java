package com.cg.expense.expense.service;

import java.util.List;

import com.cg.expense.expense.bean.Employee;
import com.cg.expense.expense.exception.EmployeeException;


public interface IEmployeeService {
	public List<Employee> getAllEmployees() throws EmployeeException;
	public void save(Employee Employee) throws EmployeeException;
	public Employee update(Employee emp, Long empId) throws EmployeeException;
	public void delete(Long emp_id) throws EmployeeException;
	public Employee getEmployeeById(Long emp_id) throws EmployeeException;
	

}
