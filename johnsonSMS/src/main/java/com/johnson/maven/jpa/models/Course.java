package com.johnson.maven.jpa.models;


import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	int cId;
	@Column(name = "name", length = 50, nullable = false)
	String cName;
	@Column(name = "Instructor", length = 50, nullable = false)
	String cInstructorName;
	
	public Course() {
		this.cName = "";
		this.cInstructorName = "";
	}
	
	public Course(String name, String instructorName) {
		this.cName = name;
		this.cInstructorName = instructorName;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcInstructorName() {
		return cInstructorName;
	}

	public void setcInstructorName(String cInstructorName) {
		this.cInstructorName = cInstructorName;
	}

	@Override
	public String toString() {
		return "Course [cId=" + cId + ", cName=" + cName + ", cInstructorName=" + cInstructorName + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cId, cInstructorName, cName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return cId == other.cId && Objects.equals(cInstructorName, other.cInstructorName)
				&& Objects.equals(cName, other.cName);
	}
	
	
}