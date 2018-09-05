package com.cg.expense.message;

public class ExpenseDetailResponse {
	private String status;
	private Object data;
	
	public ExpenseDetailResponse(){
		
	}
	
	public ExpenseDetailResponse(String status, Object data){
		this.status = status;
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ExpenseDetailResponse [status=" + status + ", data=" + data + "]";
	}
	
}
