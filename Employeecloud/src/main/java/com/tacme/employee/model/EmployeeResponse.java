package com.tacme.employee.model;

public class EmployeeResponse {
	private Object empResponse;
	
	public EmployeeResponse() {}
	
	public EmployeeResponse(Object obj) {
		this.empResponse = obj;
	}

	public Object getEmpResponse() {
		return empResponse;
	}

	public void setEmpResponse(Object empResponse) {
		this.empResponse = empResponse;
	}
}
