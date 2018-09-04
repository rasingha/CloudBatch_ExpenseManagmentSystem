package com.cg.expense.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.AccessType;


@Entity(name="expensecodetable")
public class ExpenseCode {

	@Id
	@GeneratedValue
	private int expenseCode;
	
	@NotNull(message="Please fill out this field")
	@Column(name="expense_type")
	@Size(min=3,max=15,message="Must be in characters only in range of 3 to 15 ")
	@Pattern(regexp="[A-Z]{1}[A-Za-z ]{2,15}",message="Must be in characters only in range of 3 to 15 ")
	private String expenseType;
	
	@NotNull(message="Please fill out this field")
	@Size(min=15,max=100,message="Must be in the range of 15 to 100")
	@Column(name="expense_description")
	private String expenseDescription;

	public int getExpenseCode() {
		return expenseCode;
	}

	public void setExpenseCode(int expenseCode) {
		this.expenseCode = expenseCode;
	}

	public String getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}

	public String getExpenseDescription() {
		return expenseDescription;
	}

	public void setExpenseDescription(String expenseDescription) {
		this.expenseDescription = expenseDescription;
	}
}
