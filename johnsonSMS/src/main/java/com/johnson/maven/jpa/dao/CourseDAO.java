package com.johnson.maven.jpa.dao;

import java.util.List;

import org.hibernate.Session;

import com.johnson.maven.jpa.models.Course;

public interface CourseDAO {
	
	public List<Course> getAllCourses(Session session);

}
