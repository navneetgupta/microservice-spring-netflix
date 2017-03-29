package com.tacme.student.rest;

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

import com.tacme.student.exceptions.StudentException;
import com.tacme.student.model.ApiResponse;
import com.tacme.student.model.StudentInput;
import com.tacme.student.service.StudentService;


@RestController
@RequestMapping(value = "/student", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
		MediaType.APPLICATION_JSON_VALUE })
public class StudentRestService {
	
	@Autowired StudentService studentService;
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody ApiResponse getStudentDetails(HttpServletRequest request,@PathVariable String id) throws StudentException {
    	return studentService.getStudentDetails(id);
    }
	@RequestMapping(value="/",method = RequestMethod.POST)
    public @ResponseBody ApiResponse createStudentDetails(HttpServletRequest request,@RequestBody StudentInput inpt) throws StudentException {
    	return studentService.createStudentDetails(inpt);
    }
	@RequestMapping(value="/{id}",method = RequestMethod.PUT)
    public @ResponseBody ApiResponse updateStudentDetails(HttpServletRequest request,@RequestBody StudentInput inpt,@PathVariable String id) throws StudentException {
    	return studentService.updateStudentDetails(inpt,id);
    }
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public @ResponseBody ApiResponse deleteStudentDetails(HttpServletRequest request,@PathVariable String id) throws StudentException {
    	return studentService.deleteStudentDetails(id);
    }
}
