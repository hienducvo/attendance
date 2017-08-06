package edu.mum.cs.cs544.attendance.entity;

import javax.persistence.*;
import java.util.Date;


@Entity
public class CourseOffering {
    @Id
    private String courseOfferingId;

    @ManyToOne
    @JoinColumn(name = "courseId")
    private Course course;
    
    @Temporal(TemporalType.DATE)
    private Date startDate;
    
    @Temporal(TemporalType.DATE)
    private Date endDate;
    
    @ManyToOne
    @JoinColumn(name = "locationId")
    private Location location;

    public CourseOffering() {}

    public CourseOffering(String courseOfferingId, Course course, Date startDate, Date endDate) {
    	this.courseOfferingId = courseOfferingId;
        this.course = course;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getCourseOfferingId() {
        return courseOfferingId;
    }

    public void setCourseOfferingId(String courseOfferingId) {
        this.courseOfferingId = courseOfferingId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
    
    
}
