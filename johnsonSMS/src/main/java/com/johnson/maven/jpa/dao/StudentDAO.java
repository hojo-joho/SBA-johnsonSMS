package com.johnson.maven.jpa.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import com.johnson.maven.jpa.models.Course;
import com.johnson.maven.jpa.models.Student;

public interface StudentDAO {

	public List<Student> getAllStudents(Session session);
	
	public Student getStudentByEmail(Session session, String email);
	
	public boolean validateStudent(Session session, String email, String password);
	
	public void registerStudentToCourse(Session session, Student student, List<Course> allCourses, int id);
	
	public Set<Course> getStudentCourses(Session session, String email);
}
