package com.tacme.employee.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.tacme.employee.contants.EmployeeConstants.*;
import com.tacme.employee.enity.EmployeeEntity;
import com.tacme.employee.exceptions.EmployeeException;
import com.tacme.employee.model.ApiResponse;
import com.tacme.employee.model.EmployeeInput;
import com.tacme.employee.model.EmployeeResponse;
import com.tacme.employee.model.ErrorResponse;
import com.tacme.employee.repository.EmployeeRepository;
import com.tacme.employee.service.EmployeeService;
import com.tacme.employee.utils.EmployeeUtils;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired EmployeeRepository employeeRepository;
	
	@Override
	public ApiResponse getEmployeeDetails(String id) throws EmployeeException {
		ApiResponse apiResponse = null;
		try {
			apiResponse = new ApiResponse();
			EmployeeEntity employee = employeeRepository.findByEmployeeId(id);
			if(employee != null) {
				apiResponse.setError(null);
				apiResponse.setStatus(SUCCESS);
				EmployeeResponse result = new EmployeeResponse(EmployeeUtils.convertEmployeeEntityToEmployee(employee));
				apiResponse.setResult(result);
			} else {
				apiResponse.setError(new ErrorResponse(NO_RECORD_FOUND,NO_RECORD_FOUND_MSG));
				apiResponse.setStatus(FAILED);
			}
			return apiResponse;
		} catch(DataAccessException e) {
			throw new EmployeeException(e.getMessage());
		}
	}

	@Override
	@Transactional
	public ApiResponse createEmployeeDetails(EmployeeInput inpt) throws EmployeeException {
		ApiResponse apiResponse = null;
		try {
			apiResponse = new ApiResponse();
			EmployeeEntity empEty = EmployeeUtils.convertEmployeeToEntity(inpt);
			EmployeeEntity ety = employeeRepository.saveAndFlush(empEty);
			if(ety != null) {
				apiResponse.setError(null);
				apiResponse.setStatus(SUCCESS);
				EmployeeResponse result = new EmployeeResponse(EmployeeUtils.convertEmployeeEntityToEmployee(ety));
				apiResponse.setResult(result);
			} else {
				apiResponse.setError(new ErrorResponse(CREATE_RECORD_FAILED,CREATE_RECORD_FAILED));
				apiResponse.setStatus(FAILED);
			}
			return apiResponse;
			
		} catch(DataAccessException e) {
			throw new EmployeeException(e.getMessage());
		}
	}

	@Override
	@Transactional(rollbackFor = EmployeeException.class)
	public ApiResponse updateEmployeeDetails(EmployeeInput inpt, String id) throws EmployeeException {
		ApiResponse apiResponse = null;
		try {
			apiResponse = new ApiResponse();
			EmployeeEntity emp = employeeRepository.findByEmployeeId(id);
			
			if(emp == null) 
				throw new EmployeeException();
			
			if(inpt.getName() != null) emp.setName(inpt.getName());
			if(inpt.getOrg_code() != null) emp.setOrgName(inpt.getOrg_code());
			EmployeeEntity ety = employeeRepository.saveAndFlush(emp);
			if(ety != null) {
				apiResponse.setError(null);
				apiResponse.setStatus(SUCCESS);
				EmployeeResponse result = new EmployeeResponse(EmployeeUtils.convertEmployeeEntityToEmployee(ety));
				apiResponse.setResult(result);
			} else {
				apiResponse.setError(new ErrorResponse(UPDATE_RECORD_FAILED,UPDATE_RECORD_FAILED));
				apiResponse.setStatus(FAILED);
			}
			return apiResponse;
			
		} catch(DataAccessException e) {
			throw new EmployeeException(e.getMessage());
		}
	}

	@Override
	public ApiResponse deleteEmployeeDetails(String id) throws EmployeeException {
		ApiResponse apiResponse = null;
		try {
			apiResponse = new ApiResponse();
			EmployeeEntity emp = employeeRepository.findByEmployeeId(id);
			if(emp != null) {
				employeeRepository.delete(emp);
				apiResponse.setError(null);
				apiResponse.setStatus(SUCCESS);
				EmployeeResponse result = new EmployeeResponse(EmployeeUtils.convertEmployeeEntityToEmployee(emp));
				apiResponse.setResult(result);
			} else {
				apiResponse.setError(new ErrorResponse(NO_RECORD_FOUND,NO_RECORD_FOUND_MSG));
				apiResponse.setStatus(FAILED);
			}
			return apiResponse;
			
		} catch(DataAccessException e) {
			throw new EmployeeException(e.getMessage());
		}
	}

}
