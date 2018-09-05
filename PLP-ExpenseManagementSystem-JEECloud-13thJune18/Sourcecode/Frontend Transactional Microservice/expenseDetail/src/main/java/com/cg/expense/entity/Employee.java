package com.cg.expense.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
public class Employee {
	@Id
	@GeneratedValue
	private Long emp_id;
	
	@NotNull
	@Size(min=3,message="Name should be atleast Three Characters")
	@Pattern(regexp="^[A-Z a-z]{3,30}$",message="Employee Name should Start with A capital letter")
    private String emp_name;
	
	@NotNull
	@Pattern(regexp="^[A-Z a-z]{3,20}$",message="Domain Name should Start with A capital letter")
	private String emp_domain;
	
	@NotNull
	@Pattern(regexp="^[A-Z a-z]{3,30}$",message="Designation Name should Start with A capital letter")
	private String emp_designation;
	
	@NotNull
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-mm-YYYY")
//	@Past(message="Only the past is valid and it should be in DD-MM-YYYY")
	private String emp_doj;
	
	
	
	private int emp_salary;
	
	@NotNull
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-MM-YYYY")
//	@Past(message="Only the past is valid and it should be in DD-MM-YYYY")
	private String emp_DOB;
	
	@NotNull
	@Pattern(regexp="^[A-Z a-z]{1,6}$",message="Gender should be valid Either (M,F) or (Male or Female)")
	private String emp_gender;
	
	@NotNull
	@Pattern(regexp="^[A-Z]{5}[0-9]{4}[A-Z]{1}$",message="PAN number should be in format ABCDE1234A")
	private String emp_PAN;
	
	@NotNull
	@Pattern(regexp="^[a-z]{1}[a-z0-9]+@[a-z]+.com$",message="PAN number should be in format ABCDE1234A")
	private String emp_mailId;
	
	@NotNull(message="password should not be empty")
	private String emp_password;
	
	public Long getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Long emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getEmp_domain() {
		return emp_domain;
	}

	public void setEmp_domain(String emp_domain) {
		this.emp_domain = emp_domain;
	}

	public String getEmp_designation() {
		return emp_designation;
	}

	public void setEmp_designation(String emp_designation) {
		this.emp_designation = emp_designation;
	}

	public String getEmp_doj() {
		return emp_doj;
	}

	public void setEmp_doj(String emp_doj) {
		this.emp_doj = emp_doj;
	}

	public int getEmp_salary() {
		return emp_salary;
	}

	public void setEmp_salary(int emp_salary) {
		this.emp_salary = emp_salary;
	}

	public String getEmp_DOB() {
		return emp_DOB;
	}

	public void setEmp_DOB(String emp_DOB) {
		this.emp_DOB = emp_DOB;
	}

	public String getEmp_gender() {
		return emp_gender;
	}

	public void setEmp_gender(String emp_gender) {
		this.emp_gender = emp_gender;
	}

	public String getEmp_PAN() {
		return emp_PAN;
	}

	public void setEmp_PAN(String emp_PAN) {
		this.emp_PAN = emp_PAN;
	}

	public String getEmp_mailId() {
		return emp_mailId;
	}

	public void setEmp_mailId(String emp_mailId) {
		this.emp_mailId = emp_mailId;
	}

	public String getEmp_password() {
		return emp_password;
	}

	public void setEmp_password(String emp_password) {
		this.emp_password = emp_password;
	}

}
