package com.tacme.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tacme.employee.enity.EmployeeEntity;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeEntity,Long>,JpaRepository<EmployeeEntity,Long>{
	public EmployeeEntity findByEmployeeId(String employeeId);
}
