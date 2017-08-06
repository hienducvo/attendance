package edu.mum.cs.cs544.attendance.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Timeslot {
	@Id
	private String abbreviation;

	private String description;

	@NotEmpty
	@Temporal(TemporalType.TIME)
	private Date beginTime;
	
	@NotEmpty
	@Temporal(TemporalType.TIME)
	private Date endTime;

	public Timeslot() {
	}

	public Timeslot(String abbreviation, String description, Date beginTime, Date endTime) {
		this.abbreviation = abbreviation;
		this.description = description;
		this.beginTime = beginTime;
		this.endTime = endTime;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
}
