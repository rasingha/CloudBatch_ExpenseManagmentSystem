package com.cg.expense.Expense.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.expense.Expense.bean.Employee;
import com.cg.expense.Expense.service.IEmployeeService;

@RefreshScope
@RestController
@RequestMapping("/")
public class EmployeeController {
		@Autowired
		private IEmployeeService service;
		
		@GetMapping("/employees")
		public List<Employee> getAllEmployees() {
			return service.getAllEmployees();
		}
		
		@GetMapping("/employees/{emp_id}")
		public Employee getEmployeeById(@PathVariable Long emp_id) {
			return service.getEmployeeById(emp_id);
		}
		
		@PostMapping("/employees")
		public void createEmployee(@Valid @RequestBody Employee Employee) {
			service.save(Employee);
		}
		
		@PutMapping("/employees")
		public void updateEmployee(@RequestBody Employee Employee) {
			service.update(Employee);
		}
		
		@DeleteMapping("/employees/{emp_id}")
		public void deleteEmployee(@PathVariable Long emp_id) {
			service.delete(emp_id);
		}
	}



