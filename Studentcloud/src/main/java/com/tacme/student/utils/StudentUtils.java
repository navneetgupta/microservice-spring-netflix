package com.tacme.student.utils;

import org.springframework.stereotype.Component;

import com.tacme.student.entity.StudentEntity;
import com.tacme.student.model.StudentInput;
import com.tacme.student.model.StudentModel;

@Component
public class StudentUtils {
	public static StudentModel convertStudentEntityToStudent(StudentEntity stuEntity) {
		StudentModel model = new StudentModel();
		model.setStudentId(stuEntity.getStudentId());
		model.setName(stuEntity.getName());
		model.setOrg_code(stuEntity.getOrgName());
		return model;
	}

	public static StudentEntity convertSudentToEntity(StudentInput inpt) {
		StudentEntity ety = new StudentEntity();
		ety.setName(inpt.getName());
		ety.setOrgName(inpt.getOrg_code());
		ety.setStudentId(UniqueIdGenerator.getUniqueId("stu_"));
		return ety;
	}
}
