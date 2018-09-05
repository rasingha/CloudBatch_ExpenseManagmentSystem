
$( document ).ready(function() {
	$(".pvisible").hide();
	$(".tvisible").hide();
	$("#insertClaim").hide();
	
	var expId=0;
 
	// GET REQUEST
	$("#getEmployeeId").click(function(event){
		
		event.preventDefault();
		ajaxGetEmployee();
	});
	// GET REQUEST
	$("#getProjectId").click(function(event){
		
		event.preventDefault();
		ajaxGetProjectId();
	});
$("#getExpenseTypeId").click(function(event){
		
		event.preventDefault();
		ajaxGetExpenseType();
	});
	
$("#postExpenseDetail").click(function(event){
	
	event.preventDefault();
	ajaxPost();
});
	
	function ajaxGetEmployee(){
		var empid=$("#eid").val();
		$.ajax({
			type : "GET",
			url : window.location + "/communicate/"+empid,
			success: function(result){
				if(result.status == "Done"){
					
					$.each(result.data, function(i, employee){
						$('#getResultDiv ul').empty(); 
						var employee = " Employee Id = " + employee.emp_id +"<br>"+ "Name = " + employee.emp_name + "<br>"+"" +
								"Mail Id = " + employee.emp_mailId+ "<br>"+" Domain = " + employee.emp_domain +"<br>"+ "" +
										"Designation = " + employee.emp_designation + "<br/>";
						$('#getResultDiv .list-group').append(employee)
						$(".pvisible").show();
						ajaxGetProject();
			        });
					console.log("Success: ", result);
				}else{
					$("#getResultDiv").html("<strong>Error</strong>");
					console.log("Fail: ", result);
				}
			},
			error : function(e) {
				$("#getResultDiv").html("<strong>Employee with Id : "+ empid +" not found!</strong>");
				$(".pvisible").hide();
				console.log("ERROR: ", e);
			}
		});	
	}
	function ajaxGetProject(){
		$.ajax({
			type : "GET",
			url : window.location + "/communicate/projects/",
			success: function(result){
				if(result.status == "Done"){
					  
					$.each(result.data, function(i, project){
						
						$('#mylistId')
				         .append($("<option></option>")
				                    .attr("project",i)
				                    .text(project.projectId));
						
			        });
					console.log("Success: ", result);
				}else{
					$("#getResultDiv").html("<strong>Error</strong>");
					console.log("Fail: ", result);
				}
			},
			error : function(e) {
				$("#getResultDiv").html("<strong>Employee with Id : "+ empid +" not found!</strong>");
				$("#pid").hide();
				console.log("ERROR: ", e);
			}
		});	
	}
	function ajaxGetProjectId(){
		
		var projectid=$("#mylistId").val();
		
		$.ajax({
			type : "GET",
			url : window.location + "/communicate/projects/",
			success: function(result){
				if(result.status == "Done"){
					
					$('#getProjectDiv ul').empty();
					$.each(result.data, function(i, project){
						 if(project.projectId==projectid){
							
							 var project = " Project Id = " + project.projectId +"<br>"+ "Description = " + project.projectDescription + "<br>"+"" +
								"Business Unit = " + project.businessUnit+ "<br>"+" Start Date = " + project.startDate +"<br>"+ "" +
										"End Date = " + project.endDate + "<br/>";
						$('#getProjectDiv .project-group').append(project)
						$(".tvisible").show();
						ajaxGetExpense();
						 }
						
			        });
					console.log("Success: ", result);
				}else{
					$("#getProjectDiv").html("<strong>Error</strong>");
					console.log("Fail: ", result);
				}
			},
			error : function(e) {
				$("#getProjectDiv").html("<strong>Employee with Id :  not found!</strong>");
				console.log("ERROR: ", e);
			}
		});	
	}
	function ajaxGetExpense(){
		
		$.ajax({
			type : "GET",
			url : window.location + "/communicate/expenses",
			success: function(result){
				if(result.status == "Done"){
					  
					$.each(result.data, function(i, eType){
						
						$('#mylisttId')
				         .append($("<option></option>")
				                    .attr("eType",i)
				                    .text(eType.expenseType));
						
			        });
					console.log("Success: ", result);
				}else{
					$("#getResultDiv").html("<strong>Error</strong>");
					console.log("Fail: ", result);
				}
			},
			error : function(e) {
				$("#getResultDiv").html("<strong>Employee with Id : "+ empid +" not found!</strong>");
				$("#pid").hide();
				console.log("ERROR: ", e);
			}
		});	
	}
	function ajaxGetExpenseType(){
		
		var ExpenseType=$("#mylisttId").val();
		
		$.ajax({
			type : "GET",
			url : window.location + "/communicate/expenses",
			success: function(result){
				if(result.status == "Done"){
					$('#getExpenseTypeDiv ul').empty();
					$.each(result.data, function(i, eType){
						
						 if(eType.expenseType == ExpenseType){
							expId=eType.expenseCode;
							 var expense = " Expense Id = " + eType.expenseCode +"<br>"+ "Description = " + eType.expenseDescription + "<br>"+"" +
								"Expense Type = " + eType.expenseType + "<br>";
						$('#getExpenseTypeDiv .expense-group').append(expense)
						$("#insertClaim").show();
							 
						 }
						
						
			        });
					console.log("Success: ", result);
				}else{
					$("#getExpenseTypeDiv").html("<strong>Error</strong>");
					console.log("Fail: ", result);
				}
			},
			error : function(e) {
				$("#getExpenseTypeDiv").html("<strong>Employee with Id :  not found!</strong>");
				console.log("ERROR: ", e);
			}
		});	
	}
	
function ajaxPost() {
        
		// PREPARE FORM DATA
		var formData = {
				empId : $("#eid").val(),
				projectId : $("#mylistId").val(),
				expenseId : expId,
				amount : $("#amount").val(),
				status : "Applied"
		}

		// DO POST
		$.ajax({
					type : "POST",
					contentType : "application/json",
					url : window.location + "/createExpense",
					data : JSON.stringify(formData),
					dataType : 'json',
					success : function(result) {
						if (result.status == "Done") {
							$("#claimSucess")
									.html(
											"Claimed Sucessfully");
						} else {
							$("#claimSucess").html(
									"<strong>Error</strong>");
						}
						console.log(result);
					},
					error : function(e) {
						
						console.log("ERROR: ", e);
					}
				});

		// Reset FormData after Posting
		//resetData();

	}
	
})