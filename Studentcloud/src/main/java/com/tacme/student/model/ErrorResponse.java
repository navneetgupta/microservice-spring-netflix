package com.tacme.student.model;

public class ErrorResponse {
	private String code;
	private String message;
	
	public ErrorResponse(){}
	public ErrorResponse(String code,String msg){
		this.code = code;
		this.message = msg;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
