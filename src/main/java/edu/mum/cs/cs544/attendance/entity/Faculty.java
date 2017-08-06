package edu.mum.cs.cs544.attendance.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Faculty {
	
	@Id
	private String facultyId;
	
	private String fullName;
	
	private String department;
	
	@OneToOne(cascade = CascadeType.ALL)
	private User user;
	
	public Faculty(){}
	
	public Faculty(String id, String fn, String dep){
		this.facultyId = id;
		this.fullName = fn;
		this.department = dep;
	}

	public String getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(String facultyId) {
		this.facultyId = facultyId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
