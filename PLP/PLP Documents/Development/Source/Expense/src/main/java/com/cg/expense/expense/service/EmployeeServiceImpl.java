package com.cg.expense.expense.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.expense.expense.bean.Employee;
import com.cg.expense.expense.dao.IEmployeeDao;
import com.cg.expense.expense.exception.EmployeeException;


@Service
public class EmployeeServiceImpl implements IEmployeeService{
	@Autowired
	private IEmployeeDao dao;
	//------------------------ 1. Expense Application --------------------------
		/*******************************************************************************************************
		 - Function Name	:	getAllEmployees()
		 - Input Parameters	:	no Parameters
		 - Return Type		:	Employee
		 - Throws			:  	EmployeeException
		 - Author			:	Balaji
		 - Creation Date	:	03/09/2018
		 - Description		:	Getting all Employees
		 ********************************************************************************************************/
	public List<Employee> getAllEmployees() throws EmployeeException{
		List<Employee> Employee = new ArrayList<>();
		for (Employee eapp : dao.findAll()) {
			Employee.add(eapp);
		}
		return Employee;
	}
	//------------------------ 1. Expense Application --------------------------
			/*******************************************************************************************************
			 - Function Name	:	save(Employee Employee)
			 - Input Parameters	:	Employee
			 - Return Type		:	void
			 - Throws			:  	EmployeeException
			 - Author			:	Balaji
			 - Creation Date	:	03/09/2018
			 - Description		:	Saving Employee Details
			 ********************************************************************************************************/
	@Transactional
	public void save(Employee Employee) throws EmployeeException{
		dao.save(Employee);
		
	}
	//------------------------ 1. Expense Application --------------------------
	/*******************************************************************************************************
	 - Function Name	:	update(Employee Employee,Long id)
	 - Input Parameters	:	Employee
	 - Return Type		:	Employee
	 - Throws			:  	EmployeeException
	 - Author			:	Balaji
	 - Creation Date	:	03/09/2018
	 - Description		:	Updating Employee Details
	 * @return 
	 ********************************************************************************************************/
	@Transactional
	public Employee update(Employee employee,Long id) throws EmployeeException{
		  Employee updatedEmployee=null;
		
			Employee emp = dao.findById(id).get();
			if(emp!=null) {
			 emp.setEmpName(employee.getEmpName());
			 emp.setEmpDomain(employee.getEmpDomain());
			 emp.setEmpDesignation(employee.getEmpDesignation());
			 emp.setEmpDoj(employee.getEmpDoj());
			 emp.setEmpSalary(employee.getEmpSalary());
			 emp.setEmpDob(employee.getEmpDob());
			 emp.setEmpGender(employee.getEmpGender());
			 emp.setEmpPan(employee.getEmpPan());
			 emp.setEmpEmail(employee.getEmpEmail());
			 emp.setEmpPassword(employee.getEmpPassword());
			 updatedEmployee = dao.save(emp);
			}
		return updatedEmployee;
		
	}
	//------------------------ 1. Expense Application --------------------------
	/*******************************************************************************************************
	 - Function Name	:	delete(Long empId)
	 - Input Parameters	:	Employee
	 - Return Type		:	void
	 - Throws			:  	EmployeeException
	 - Author			:	Balaji
	 - Creation Date	:	03/09/2018
	 - Description		:	Deleting Employee Details
	 ********************************************************************************************************/
	@Transactional
	public void delete(Long empId) throws EmployeeException{
		dao.deleteById(empId);
		
	}
	//------------------------ 1. Expense Application --------------------------
	/*******************************************************************************************************
	 - Function Name	:	getEmployeeById(Long empId)
	 - Input Parameters	:	Employee
	 - Return Type		:	Employee
	 - Throws			:  	EmployeeException
	 - Author			:	Balaji
	 - Creation Date	:	03/09/2018
	 - Description		:	Getting an Employee Detail
	 ********************************************************************************************************/
	public Employee getEmployeeById(Long empId) throws EmployeeException{
		return dao.findById(empId).get();
	}

}
