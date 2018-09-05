package com.cg.expense.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
public class ProjectCodeBean 
{
	@Id
	@GeneratedValue
	private int projectId;
	
	
	@NotEmpty(message="Project Description cannot be empty.")
	@Size(min=10,message="Project Description should have minimum 10 characters")
	@Pattern(regexp = "^[a-zA-Z]\\w{10,}$",message="Project Description's first character must be a letter, it must contain at least 10 characters and no characters other than letters, numbers and the underscore may be used(like 'IN03_CFMG_Freshers_training')")
	private String projectDescription;
	
	@NotEmpty(message="Business unit cannot be empty.")
	@Size(min=3,message="Business unit should have minimum 3 letters")
	@Pattern(regexp = "^[A-Z]{3,}$", message= "Should have minimum 3 letters all in uppercase.")
	private String businessUnit;
	
	@NotEmpty(message="Start Date should not be empty and should be in format YYYY-MM-DD ")
	@Pattern(regexp="^^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$",message="Start Date should be in format dd/mm/yyyy")
	private String startDate;
	
	@NotEmpty(message="End Date should not be empty and should be in format YYYY-MM-DD ")
	@Pattern(regexp="^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$",message="End Date should be in format dd/mm/yyyy")
	private String endDate;

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public String getBusinessUnit() {
		return businessUnit;
	}

	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}

	
	public String getStartDate() {
		return startDate;
	}

	
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	
	public String getEndDate() {
		return endDate;
	}

	
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	
}
