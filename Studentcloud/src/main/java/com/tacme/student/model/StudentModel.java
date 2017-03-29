package com.tacme.student.model;

import java.io.Serializable;

public class StudentModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String studentId;
	private String name;
	private String org_code;
	
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
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
