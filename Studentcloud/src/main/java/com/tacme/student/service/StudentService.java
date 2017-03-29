package com.tacme.student.service;


import com.tacme.student.model.ApiResponse;
import com.tacme.student.model.StudentInput;
import com.tacme.student.exceptions.StudentException;

public interface StudentService  {
	public ApiResponse getStudentDetails(String id) throws StudentException;

	public ApiResponse createStudentDetails(StudentInput inpt) throws StudentException;

	public ApiResponse updateStudentDetails(StudentInput inpt, String id) throws StudentException;

	public ApiResponse deleteStudentDetails(String id) throws StudentException;
}
