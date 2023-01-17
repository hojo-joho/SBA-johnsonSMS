package com.johnson.maven.jpa.services;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.johnson.maven.jpa.dao.CourseDAO;
import com.johnson.maven.jpa.models.Course;

public class CourseService extends SmsUtil implements CourseDAO {

	@Override
	public List<Course> getAllCourses(Session session) {

		TypedQuery<Course> hql = session.createQuery("FROM Course", Course.class);
		try{ 
		List<Course> allCourses = hql.getResultList();
		return allCourses;
		} catch (Exception e) {
			System.out.println("Could not retrieve courses");
			return null;
		}
	}

}
