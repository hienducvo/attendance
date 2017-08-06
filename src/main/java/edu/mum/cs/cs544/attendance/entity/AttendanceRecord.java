package edu.mum.cs.cs544.attendance.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class AttendanceRecord {
	@Id
	@GeneratedValue
	private int id;

	@ManyToOne
	@JoinColumn(name = "studentId")
	private Student student;

	@ManyToOne
	@JoinColumn(name = "timeslotId")
	private Timeslot timeslot;

	@ManyToOne
	@JoinColumn(name = "locationId")
	private Location location;

	@Temporal(TemporalType.DATE)
	private Date date;

	public AttendanceRecord() {
	}

	public AttendanceRecord(Student student, Timeslot timeslot, Location location, Date date) {
		this.student = student;
		this.timeslot = timeslot;
		this.location = location;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Timeslot getTimeslot() {
		return timeslot;
	}

	public void setTimeslot(Timeslot timeslot) {
		this.timeslot = timeslot;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
