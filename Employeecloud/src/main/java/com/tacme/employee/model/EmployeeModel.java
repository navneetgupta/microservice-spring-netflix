package com.tacme.employee.model;

import java.io.Serializable;

public class EmployeeModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String employeeId;
	private String name;
	private String org_code;
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrg_code() {
		return org_code;
	}
	public void setOrg_code(String org_code) {
		this.org_code = org_code;
	}
}
