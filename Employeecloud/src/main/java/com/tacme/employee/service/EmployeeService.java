package com.tacme.employee.service;

import com.tacme.employee.exceptions.EmployeeException;
import com.tacme.employee.model.ApiResponse;
import com.tacme.employee.model.EmployeeInput;

public interface EmployeeService {
	public ApiResponse getEmployeeDetails(String id) throws EmployeeException;

	public ApiResponse createEmployeeDetails(EmployeeInput inpt) throws EmployeeException;

	public ApiResponse updateEmployeeDetails(EmployeeInput inpt, String id) throws EmployeeException;

	public ApiResponse deleteEmployeeDetails(String id) throws EmployeeException;
}
