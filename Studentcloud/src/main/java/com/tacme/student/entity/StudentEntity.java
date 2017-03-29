package com.tacme.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_info")
public class StudentEntity {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	
	@Column(name = "student_id")
	private String studentId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "org_name")
	private String orgName;

	public StudentEntity() {}
	
	public StudentEntity(String name,String studentId, String orgName) {
		this.name = name;
		this.studentId = studentId;
		this.orgName = orgName;
	}
	
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	
}
