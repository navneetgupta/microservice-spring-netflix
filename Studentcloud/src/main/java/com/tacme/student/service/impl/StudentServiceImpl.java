package com.tacme.student.service.impl;

import static com.tacme.student.constants.StudentConstants.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tacme.student.entity.StudentEntity;
import com.tacme.student.exceptions.StudentException;
import com.tacme.student.model.ApiResponse;
import com.tacme.student.model.ErrorResponse;
import com.tacme.student.model.StudentInput;
import com.tacme.student.model.StudentResponse;
import com.tacme.student.repository.StudentRepository;
import com.tacme.student.service.StudentService;
import com.tacme.student.utils.StudentUtils;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired StudentRepository studentRepository;
	@Override
	public ApiResponse getStudentDetails(String id) throws StudentException {
		ApiResponse apiResponse = null;
		try {
			apiResponse = new ApiResponse();
			StudentEntity studentEty = studentRepository.findByStudentId(id);
			if(studentEty != null) {
				apiResponse.setError(null);
				apiResponse.setStatus(SUCCESS);
				StudentResponse result = new StudentResponse(StudentUtils.convertStudentEntityToStudent(studentEty));
				apiResponse.setResult(result);
			} else {
				apiResponse.setError(new ErrorResponse(NO_RECORD_FOUND,NO_RECORD_FOUND_MSG));
				apiResponse.setStatus(FAILED);
			}
			return apiResponse;
		}catch(DataAccessException e) {
			throw new StudentException(e.getMessage());
		}
	}
	
	@Override
	@Transactional
	public ApiResponse createStudentDetails(StudentInput inpt) throws StudentException {
		ApiResponse apiResponse = null;
		try {
			apiResponse = new ApiResponse();
			StudentEntity stuEty = StudentUtils.convertSudentToEntity(inpt);
			StudentEntity stu = studentRepository.saveAndFlush(stuEty);
			if(stu != null) {
				apiResponse.setError(null);
				apiResponse.setStatus(SUCCESS);
				StudentResponse result = new StudentResponse(StudentUtils.convertStudentEntityToStudent(stu));
				apiResponse.setResult(result);
			} else {
				apiResponse.setError(new ErrorResponse(CREATE_RECORD_FAILED,CREATE_RECORD_FAILED));
				apiResponse.setStatus(FAILED);
			}
			return apiResponse;
			
		} catch(DataAccessException e) {
			throw new StudentException(e.getMessage());
		}
	}
	
	@Override
	@Transactional(rollbackFor = StudentException.class)
	public ApiResponse updateStudentDetails(StudentInput inpt, String id) throws StudentException {
		ApiResponse apiResponse = null;
		try {
			apiResponse = new ApiResponse();
			StudentEntity stuEty = studentRepository.findByStudentId(id);
			
			if(stuEty == null) 
				throw new StudentException();
			
			if(inpt.getName() != null) stuEty.setName(inpt.getName());
			if(inpt.getOrg_code() != null) stuEty.setOrgName(inpt.getOrg_code());
			StudentEntity stu = studentRepository.saveAndFlush(stuEty);
			if(stu != null) {
				apiResponse.setError(null);
				apiResponse.setStatus(SUCCESS);
				StudentResponse result = new StudentResponse(StudentUtils.convertStudentEntityToStudent(stu));
				apiResponse.setResult(result);
			} else {
				apiResponse.setError(new ErrorResponse(UPDATE_RECORD_FAILED,UPDATE_RECORD_FAILED));
				apiResponse.setStatus(FAILED);
			}
			return apiResponse;
			
		} catch(DataAccessException e) {
			throw new StudentException(e.getMessage());
		}
	}
	
	@Override
	public ApiResponse deleteStudentDetails(String id) throws StudentException {
		ApiResponse apiResponse = null;
		try {
			apiResponse = new ApiResponse();
			StudentEntity stu = studentRepository.findByStudentId(id);
			if(stu != null) {
				studentRepository.delete(stu);
				apiResponse.setError(null);
				apiResponse.setStatus(SUCCESS);
				StudentResponse result = new StudentResponse(StudentUtils.convertStudentEntityToStudent(stu));
				apiResponse.setResult(result);
			} else {
				apiResponse.setError(new ErrorResponse(NO_RECORD_FOUND,NO_RECORD_FOUND_MSG));
				apiResponse.setStatus(FAILED);
			}
			return apiResponse;
			
		} catch(DataAccessException e) {
			throw new StudentException(e.getMessage());
		}
	}
	

}
