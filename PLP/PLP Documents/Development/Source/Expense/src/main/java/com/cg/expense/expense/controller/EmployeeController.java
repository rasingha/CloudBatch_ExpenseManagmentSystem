package com.cg.expense.expense.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.expense.expense.bean.Employee;
import com.cg.expense.expense.service.IEmployeeService;

@RestController
@RequestMapping("/")
public class EmployeeController {
		@Autowired
		private IEmployeeService service;
		
		@GetMapping("/getall")
		public List<Employee> getAllEmployees() {
			return service.getAllEmployees();
		}
		
		@GetMapping("/getbyid/{empId}")
		public Employee getEmployeeById(@PathVariable Long empId) {
			return service.getEmployeeById(empId);
		}
		
		@PostMapping("/create")
		public void createEmployee(@Valid @RequestBody Employee employee) {
			service.save(employee);
		}
		
		@PutMapping("/update/{empId}")
		public void updateEmployee(@PathVariable(value = "empId") Long empId,
                @Valid @RequestBody Employee employee) {
			service.update(employee,empId);
		}
		
		@DeleteMapping("/delete/{empId}")
		public void deleteEmployee(@PathVariable Long empId) {
			service.delete(empId);
		}
	}



