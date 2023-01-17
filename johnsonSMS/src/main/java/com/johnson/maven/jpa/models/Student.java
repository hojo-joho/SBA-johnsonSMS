package com.johnson.maven.jpa.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "email", length = 50)
	private String sEmail;
	@Column(name = "name", length = 50)
	private String sName;
	@Column(name = "password", length = 50)
	private String sPass;
	@ManyToMany(targetEntity = Course.class, cascade= {CascadeType.ALL})
	private Set<Course> sCourses;

	public Student() {
		this.sEmail = "";
		this.sName = "";
		this.sPass = "";
		this.sCourses = new HashSet<Course>();
	}

	public Student(String sEmail, String sName, String sPass, Set<Course> sCourses) {
		super();
		this.sEmail = sEmail;
		this.sName = sName;
		this.sPass = sPass;
		this.sCourses = sCourses;
	}


	public String getsEmail() {
		return sEmail;
	}

	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsPass() {
		return sPass;
	}

	public void setsPass(String sPass) {
		this.sPass = sPass;
	}


	public Set<Course> getsCourses() {
		return sCourses;
	}

	public void setsCourses(Set<Course> sCourses) {
		this.sCourses = sCourses;
	}

	@Override
	public String toString() {
		return "Student [sEmail=" + sEmail + ", sName=" + sName + ", sPass=" + sPass
				+ ", sCourses=" + sCourses + "]";
	}


}
