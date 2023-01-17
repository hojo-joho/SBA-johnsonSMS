package com.johnson.maven.jpa.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.johnson.maven.jpa.dao.StudentDAO;
import com.johnson.maven.jpa.models.Course;
import com.johnson.maven.jpa.models.Student;

public class StudentService extends SmsUtil implements StudentDAO {

	@Override
	public List<Student> getAllStudents(Session session) {

		TypedQuery<Student> hql = session.createQuery("FROM Student", Student.class);
		List<Student> allStudents = new ArrayList<>();
		
		try {
			allStudents = hql.getResultList();
		} catch (Exception e) {
			System.out.println("No students available");
		}
		
		return allStudents;
	}

	@Override
	public Student getStudentByEmail(Session session, String email) {

		TypedQuery<Student> query = session.createQuery("FROM Student WHERE email = :email", Student.class);
		query.setParameter("email", email);
		try {
			Student student = query.getSingleResult();
			return student;

		} catch (Exception e) {
			System.out.println("No students found");
			return null;
		}
	}

	@Override
	public boolean validateStudent(Session session, String email, String password) {
		try {
			Student student = getStudentByEmail(session, email);
			String sPass = student.getsPass();
			if (sPass.compareToIgnoreCase(password) == 0) {
				return true;
			} else {
				System.out.println("Wrong Credentials");
				return false;}
			} catch (Exception e) {
				System.out.println("Unable to validate");
				return false;
			}
	}

	
	@Override
	public void registerStudentToCourse(Session session, Student student, List<Course> allCourses, int id) {
		Course choice = allCourses.get(id);
		Set<Course> sCourses =student.getsCourses();
		
		sCourses.add(choice);
		session.save(choice);
		
		student.setsCourses(sCourses);
		session.save(student);
	}

	@Override
	public Set<Course> getStudentCourses(Session session, String email) {
		
		Student student = getStudentByEmail(session, email);
		Set<Course> courseSet = student.getsCourses();
		
		return courseSet;
		
		}
	}

