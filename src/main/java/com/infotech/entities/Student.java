package com.infotech.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
//student +courses, student class is owning entity
@Entity
@Table(name = "STUDENT")
//@SecondaryTables({
//    @SecondaryTable(name="name", pkJoinColumns={
//        @PrimaryKeyJoinColumn(name="id", referencedColumnName="STUDENT_ID") })
//})

@SecondaryTable(name="student_detail")
public class Student {
	@Id
	@GeneratedValue
	@Column(name = "STUDENT_ID")
	private long studentId;
	
	@Column(name = "STUDENT_NAME", nullable = false, length = 100)
	private String studentName;
	
	@Column(name="phone_number",table="student_detail")
	private String phoneNumber;
	
	

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "STUDENT_COURSE", joinColumns = { @JoinColumn(name = "STUDENT_ID")}, inverseJoinColumns = { @JoinColumn(name = "COURSE_ID") })
	private Set<Course>courses = new HashSet<Course>();

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	public Student() {
	}

	public Student(String studentName) {
		this.studentName = studentName;
	}

	public Student(String studentName, Set<Course> courses) {
		this.studentName = studentName;
		this.courses = courses;
	}
}
