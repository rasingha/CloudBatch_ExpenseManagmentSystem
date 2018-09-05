package com.cg.expense.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.cg.expense.entity.Employee;
import com.cg.expense.entity.ExpenseCode;
import com.cg.expense.entity.ExpenseDetail;
import com.cg.expense.entity.ProjectCodeBean;
import com.cg.expense.exception.ExpenseDetailException;
import com.cg.expense.exception.ExpenseNotFoundException;
import com.cg.expense.message.ExpenseDetailResponse;
import com.cg.expense.service.IExpenseDetailService;
import com.netflix.discovery.EurekaClient;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@RestController
@RequestMapping("/")
public class ExpenseDetailController{
	
	@Autowired
    private RestTemplate restTemplate;
	
    @Autowired
    private EurekaClient eurekaClient;
    

	@Autowired
	IExpenseDetailService expenseDetailService;
	
	
	 @RequestMapping("/communicate/{employeeId}")
	    public ExpenseDetailResponse findme(@PathVariable Long employeeId) {
	        Application application = eurekaClient.getApplication("employeecode");
	        InstanceInfo instanceInfo = application.getInstances().get(0);
	        String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/Employee/" + "employees/" + employeeId;
	        Employee emp = restTemplate.getForObject(url, Employee.class);
	        ArrayList<Employee> ls=new ArrayList<Employee>();
	        ls.add(emp);
	        ExpenseDetailResponse response = new ExpenseDetailResponse("Done", ls);
			return response;
	    }
	
	 @RequestMapping("/communicate/projects/")
	    public ExpenseDetailResponse getAllProjects() {
	        Application application = eurekaClient.getApplication("ProjectCode");
	        InstanceInfo instanceInfo = application.getInstances().get(0);
	        String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() +"Project/"+ "api/" + "project/" ;
	        ResponseEntity<List<ProjectCodeBean>> response = restTemplate.exchange(
	        		  url,
	        		  HttpMethod.GET,
	        		  null,
	        		  new ParameterizedTypeReference<List<ProjectCodeBean>>(){});
	        		List<ProjectCodeBean> projects =new ArrayList<ProjectCodeBean>();
	        		 projects = response.getBody();
	        		ExpenseDetailResponse response1 = new ExpenseDetailResponse("Done", projects);
	    			return response1;
	    }
	 
	 @RequestMapping("/communicate/expenses")
	    public ExpenseDetailResponse getAllExpenses() {
	        Application application = eurekaClient.getApplication("ExpenseCode");
	        InstanceInfo instanceInfo = application.getInstances().get(0);
	        String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() +"/Expense/" + "expenses" ;
	        ResponseEntity<List<ExpenseCode>> response = restTemplate.exchange(
	        		  url,
	        		  HttpMethod.GET,
	        		  null,
	        		  new ParameterizedTypeReference<List<ExpenseCode>>(){});
	        		List<ExpenseCode> expenses =new ArrayList<ExpenseCode>(); 
	        		expenses=response.getBody();
	        		ExpenseDetailResponse response2 = new ExpenseDetailResponse("Done", expenses);
	    			return response2;
	    }
	 
	@GetMapping("/getclaim/{claimId}")
	public ExpenseDetail getEmployeeDetailsById(@PathVariable long claimId) 
	{
		ExpenseDetail expenseDetailOfId = null;
		
			expenseDetailOfId=expenseDetailService.getEmployeeDetailsById(claimId);
			
		
		if(expenseDetailOfId==null)
		{
			throw new ExpenseNotFoundException("Claim Id not Found !");
			
		}
		return expenseDetailOfId;
	}
	
	
//	@GetMapping("/getemp/{empId}")
//	public List<ExpenseDetail> getEmployeeDetailsByEmpId(@PathVariable long empId) 
//	{
//		List<ExpenseDetail> explist=expenseDetailService.getEmployeeDetailsByEmpId(empId);
//		
//		return explist;
//	}
	
	@PostMapping("/createExpense")
	public ExpenseDetailResponse save(@RequestBody ExpenseDetail expense)
	{
		expenseDetailService.createExpense(expense);
		ExpenseDetailResponse response = new ExpenseDetailResponse("Done", expense);
		return response;
	}
	
	@PutMapping("/updateExpense")
	public void update(@RequestBody ExpenseDetail expense)
	{
		expenseDetailService.updateExpense(expense);
	}
	
	@DeleteMapping("/deleteExpense/{claimId}")
	public void del(@PathVariable Long claimId)
	{
		expenseDetailService.deleteExpense(claimId);
	}
	
	@GetMapping("/expensedetails")
	public List<ExpenseDetail> getAllDonors()
	{
	 return expenseDetailService.getAllExpenseDeatils();
	}
	
	
}
