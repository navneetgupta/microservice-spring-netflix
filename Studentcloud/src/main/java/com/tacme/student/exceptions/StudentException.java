package com.tacme.student.exceptions;

public class StudentException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public StudentException() {}
	
	public StudentException(String message) {
		super(message);
	}
	public StudentException(Throwable cause) {
		super(cause);
	}
	public StudentException(String message, Throwable cause) {
		super(message,cause);
	}

}
