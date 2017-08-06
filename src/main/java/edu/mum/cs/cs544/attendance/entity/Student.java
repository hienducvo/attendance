package edu.mum.cs.cs544.attendance.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Student {
	
	@Id
	private String studentId;
	
	@NotEmpty(message="name should not be empty")
	private String firstName;
		
	@NotEmpty(message="name should not be empty")
	private String lastName;
    
	@NotEmpty(message="barcode should not be empty")
	private String barCode;
	
	@OneToOne(cascade = CascadeType.ALL)
	private User user;

	public Student() {
	}

	public Student(String studentId, String firstName, String lastName, String barCode) {
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.barCode = barCode;
	}
	
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
