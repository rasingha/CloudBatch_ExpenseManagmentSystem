package com.cg.expense.expense.util;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class DateValidator implements ConstraintValidator <DateConstraint,String >{
	 @Override
	    public void initialize(DateConstraint dateField) {
	    }
	 


		@Override
		public boolean isValid(String dateField, ConstraintValidatorContext cxt) {
			// TODO Auto-generated method stub

			if(dateField != null && dateField.matches("(^(((0[1-9]|1[0-9]|2[0-8])[\\/](0[1-9]|1[012]))|((29|30|31)[\\/](0[13578]|1[02]))|((29|30)[\\/](0[4,6,9]|11)))[\\/](19|[2-9][0-9])\\d\\d$)|(^29[\\/]02[\\/](19|[2-9][0-9])(00|04|08|12|16|20|24|28|32|36|40|44|48|52|56|60|64|68|72|76|80|84|88|92|96)$)"))
			{
				
				return true;
				
				
			}
			else
			 return false;
		}

}
