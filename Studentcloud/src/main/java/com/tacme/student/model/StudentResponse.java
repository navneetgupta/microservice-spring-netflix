package com.tacme.student.model;

public class StudentResponse {
	private Object studentResp;

	public StudentResponse(){}	
	
	public StudentResponse(Object obj){
		this.studentResp = obj;
	}

	public Object getStudentResp() {
		return studentResp;
	}

	public void setStudentResp(Object studentResp) {
		this.studentResp = studentResp;
	}
}
