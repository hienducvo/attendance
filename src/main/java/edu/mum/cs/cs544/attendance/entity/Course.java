package edu.mum.cs.cs544.attendance.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Course {
    @Id
    @NotBlank
    private String courseId;
    
    @NotBlank
    private String name;

    private String description;

    public Course() {}

    public Course(String courseId, String name, String description) {
    	this.courseId = courseId;
        this.name = name;
        this.description = description;
    }
    
   
	public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
