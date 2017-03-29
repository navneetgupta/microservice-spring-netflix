package com.tacme.employee.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tacme.employee.exceptions.EmployeeException;
import com.tacme.employee.model.ApiResponse;
import com.tacme.employee.model.EmployeeInput;
import com.tacme.employee.service.EmployeeService;


@RestController
@RequestMapping(value = "/employee", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
		MediaType.APPLICATION_JSON_VALUE })
public class EmployeeRestService {
	
	@Autowired EmployeeService employeeService;
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody ApiResponse getEmployeeDetails(HttpServletRequest request,@PathVariable String id) throws EmployeeException {
    	System.out.println("header roles ========== " + request.getHeader("service_roles"));
		return employeeService.getEmployeeDetails(id);
    }
	@RequestMapping(value="/",method = RequestMethod.POST)
    public @ResponseBody ApiResponse createEmployeeDetails(HttpServletRequest request,@RequestBody EmployeeInput inpt) throws EmployeeException {
		System.out.println("header roles ========== " + request.getHeader("service_roles"));
		return employeeService.createEmployeeDetails(inpt);
    }
	@RequestMapping(value="/{id}",method = RequestMethod.PUT)
    public @ResponseBody ApiResponse updateEmployeeDetails(HttpServletRequest request,@RequestBody EmployeeInput inpt,@PathVariable String id) throws EmployeeException {
		System.out.println("header roles ========== " + request.getHeader("service_roles"));
		return employeeService.updateEmployeeDetails(inpt,id);
    }
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public @ResponseBody ApiResponse deleteEmployeeDetails(HttpServletRequest request,@PathVariable String id) throws EmployeeException {
		System.out.println("header roles ========== " + request.getHeader("service_roles"));
		return employeeService.deleteEmployeeDetails(id);
    }
}
