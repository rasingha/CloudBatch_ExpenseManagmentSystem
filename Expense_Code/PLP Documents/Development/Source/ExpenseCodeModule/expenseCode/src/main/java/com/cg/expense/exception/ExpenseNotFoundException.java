package com.cg.expense.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/************************************************************************************
 * File:  	 ExpenseNotFoundException.java
 * Package:  com.cg.expense.exception
 * Desc: 	 Exception class for the Module: Expense Code
 * Version:  1.0
 * Modifications: -
 * Author: Amruta Deokar   Date:  29-August-2018   Change Description: -
 ************************************************************************************/

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ExpenseNotFoundException extends RuntimeException {

  public ExpenseNotFoundException(String exception) {
    super(exception);
  }

}