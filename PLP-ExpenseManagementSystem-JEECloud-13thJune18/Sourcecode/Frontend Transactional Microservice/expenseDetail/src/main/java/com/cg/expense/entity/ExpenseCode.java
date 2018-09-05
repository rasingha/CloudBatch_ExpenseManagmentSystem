package com.cg.expense.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity(name="expensecodetable")
public class ExpenseCode {

	@Id
	@GeneratedValue
	private int expenseCode;
	
	@NotNull(message="Expense Type can't be empty.")
	@Column(name="expense_type")
	@Size(min=3,max=25,message="The expense type should be atleast 3 characters and atmost 25 characters long.")
	@Pattern(regexp="[A-Z]{1}[A-Za-z ]{2,25}",message="The expene Type must contain only characters.")
	private String expenseType;
	
	@NotNull(message="Expense Description cant be empty.")
	@Size(min=20,message="The description should be at least 20 characters")
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
