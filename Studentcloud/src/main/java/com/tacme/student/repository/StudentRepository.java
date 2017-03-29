package com.tacme.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tacme.student.entity.StudentEntity;

@Repository
public interface StudentRepository extends CrudRepository<StudentEntity,Long>,JpaRepository<StudentEntity,Long> {
	public StudentEntity findByStudentId(String studentId);
}
