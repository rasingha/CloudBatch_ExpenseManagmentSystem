package com.cg.expense.expense.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator <AgeConstraint,String >{
	

	@Override
	public void initialize(AgeConstraint dateField) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String dateField, ConstraintValidatorContext arg1) {
		if(dateField != null && dateField.matches("(^(((0[1-9]|1[0-9]|2[0-8])[\\/](0[1-9]|1[012]))|((29|30|31)[\\/](0[13578]|1[02]))|((29|30)[\\/](0[4,6,9]|11)))[\\/](19|[2-9][0-9])\\d\\d$)|(^29[\\/]02[\\/](19|[2-9][0-9])(00|04|08|12|16|20|24|28|32|36|40|44|48|52|56|60|64|68|72|76|80|84|88|92|96)$)"))
		{
			Date date = new Date(); 
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
			try {
				Date date1 = (Date)dateFormat.parse(dateField);
				Calendar calendar = new GregorianCalendar();
				calendar.setTime(date1);
				int year = calendar.get(Calendar.YEAR);
				calendar.setTime(date);
				int sysYear=calendar.get(Calendar.YEAR);
				
				if(date.after(date1))
				{
					if((sysYear-year)>=19)
					{
						return true;
					}
					else
						return false;
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				System.out.println("Date Parsing is not done");
			}
			return false;
			
			
		}
		else
		 return false;
	}
	

}
