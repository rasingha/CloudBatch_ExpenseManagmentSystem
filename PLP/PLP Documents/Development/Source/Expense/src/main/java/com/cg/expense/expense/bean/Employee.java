package com.cg.expense.expense.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.cg.expense.expense.util.AgeConstraint;
import com.cg.expense.expense.util.DateConstraint;
@Entity
public class Employee {
	@Id
	@GeneratedValue
	private Long empId;
	
	@NotNull
	@Size(min=3,message="Name should be atleast Three Characters")
	@Pattern(regexp="^[A-Z]{1}[A-Z \\sa-z]{2,30}$",message="Employee Name should Start with a capital letter followed by combination of lowercase and uppercase letters within range of 3 to 30 characters.")
    private String empName;
	
	@NotNull
	@Pattern(regexp="^[A-Z]{1}[A-Za-z]{2,30}$",message="Employee Domain should Start with a capital letter followed by combination of lowercase and uppercase letters within range of 3 to 20 characters.")
	private String empDomain;
	
	@NotNull
	@Pattern(regexp="^[A-Z]{1}[ a-z]{2,30}$",message="Employee Designation should Start with a capital letter followed by combination of lowercase and uppercase letters within range of 3 to 30 characters.")
	private String empDesignation;
	
	@NotNull
	@DateConstraint
	private String empDoj;

	@NotNull
	@Pattern(regexp="^[0-9]+$",message="Salary should be in positive numbers ")
	private String empSalary;
	
	@NotNull
	@AgeConstraint
	private String empDob;
	
	@NotNull
	@Pattern(regexp="M|F|Female|Male|O|Other",message="Gender should be valid Either (M,F,O) or (Male or Female or Other)")
	private String empGender;
	
	@NotNull
	@Pattern(regexp="^[A-Z]{5}[0-9]{4}[A-Z]{1}$",message="PAN number should be in format ABCDE1234A")
	private String empPan;
	
	@NotNull
	@Pattern(regexp="^[a-z]{1}[a-z0-9]+@[a-z]+.com$",message="EMAIL should be in format of [abc@capgemini.com]")
	private String empEmail;
	
	@NotNull(message="password should not be empty")
	@Pattern(regexp="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}",message="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters")
	private String empPassword;
	
	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long emp_id) {
		this.empId = emp_id;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String emp_name) {
		this.empName = emp_name;
	}

	public String getEmpDomain() {
		return empDomain;
	}

	public void setEmpDomain(String emp_domain) {
		this.empDomain = emp_domain;
	}

	public String getEmpDesignation() {
		return empDesignation;
	}

	public void setEmpDesignation(String emp_designation) {
		this.empDesignation = emp_designation;
	}

	public String getEmpDoj() {
		return empDoj;
	}

	public void setEmpDoj(String emp_doj) {
		this.empDoj = emp_doj;
	}

	public String getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(String emp_salary) {
		this.empSalary = emp_salary;
	}

	public String getEmpDob() {
		return empDob;
	}

	public void setEmpDob(String emp_DOB) {
		this.empDob = emp_DOB;
	}

	public String getEmpGender() {
		return empGender;
	}

	public void setEmpGender(String emp_gender) {
		this.empGender = emp_gender;
	}

	public String getEmpPan() {
		return empPan;
	}

	public void setEmpPan(String emp_PAN) {
		this.empPan = emp_PAN;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String emp_mailId) {
		this.empEmail = emp_mailId;
	}

	public String getEmpPassword() {
		return empPassword;
	}

	public void setEmpPassword(String emp_password) {
		this.empPassword = emp_password;
	}

}
