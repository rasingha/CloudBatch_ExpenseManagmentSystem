package com.cg.expense.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.expense.entity.ExpenseDetail;

public interface IExpenseDetailRepository extends JpaRepository<ExpenseDetail, Long>{

//	@Query("select ex.empid from expense_detail ex where ex.empid= :empId")
//	List<ExpenseDetail> getEmployeeDetailsByEmpId(@Param("empId") long empId);
	
	
}
