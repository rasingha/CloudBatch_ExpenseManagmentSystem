package com.cg.expense.Expense.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.expense.Expense.bean.Employee;
import com.cg.expense.Expense.dao.IEmployeeDao;
import com.cg.expense.Expense.exception.EmployeeException;


@Service
public class EmployeeServiceImpl implements IEmployeeService{
	@Autowired
	private IEmployeeDao dao;

	public List<Employee> getAllEmployees() throws EmployeeException{
		List<Employee> Employee = new ArrayList<>();
		for (Employee eapp : dao.findAll()) {
			Employee.add(eapp);
		}
		return Employee;
	}

	@Transactional
	public void save(Employee Employee) throws EmployeeException{
		dao.save(Employee);
		
	}

	@Transactional
	public void update(Employee Employee) throws EmployeeException{
		dao.save(Employee);
		
	}

	@Transactional
	public void delete(Long emp_id) throws EmployeeException{
		dao.deleteById(emp_id);
		
	}

	public Employee getEmployeeById(Long emp_id) throws EmployeeException{
		return dao.findById(emp_id).get();
	}

}
