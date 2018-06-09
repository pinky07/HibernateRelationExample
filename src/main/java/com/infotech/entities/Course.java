package com.infotech.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="COURSE")
public class Course {
	@Id
	@GeneratedValue
	@Column(name="COURSE_ID")
	private long courseId;
	
	
	@Column(name="COURSE_NAME", nullable=false)
	private String courseName;
	
	@ManyToMany
	private Set<Student>students= new HashSet<Student>();
	
	public Course() {
	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Course(String courseName) {
		this.courseName = courseName;
	}
}
