package com.tacme.employee.utils;

import org.springframework.stereotype.Component;

import com.tacme.employee.enity.EmployeeEntity;
import com.tacme.employee.model.EmployeeInput;
import com.tacme.employee.model.EmployeeModel;

@Component
public class EmployeeUtils {
	public static EmployeeModel convertEmployeeEntityToEmployee(EmployeeEntity empEntity) {
		EmployeeModel model = new EmployeeModel();
		model.setEmployeeId(empEntity.getEmployeeId());
		model.setName(empEntity.getName());
		model.setOrg_code(empEntity.getOrgName());
		return model;
	}

	public static EmployeeEntity convertEmployeeToEntity(EmployeeInput inpt) {
		EmployeeEntity ety = new EmployeeEntity();
		ety.setName(inpt.getName());
		ety.setOrgName(inpt.getOrg_code());
		ety.setEmployeeId(UniqueIdGenerator.getUniqueId("emp_"));
		return ety;
	}
}
