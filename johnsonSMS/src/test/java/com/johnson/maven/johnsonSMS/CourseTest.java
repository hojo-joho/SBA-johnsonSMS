package com.johnson.maven.johnsonSMS;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.johnson.maven.jpa.models.Course;
import com.johnson.maven.jpa.services.CourseService;

public class CourseTest {

	Configuration configuration = new Configuration();
	SessionFactory factory = configuration.configure().buildSessionFactory();
	Session session = factory.openSession();
	
	CourseService csrv = new CourseService();
	
	@Test
	public void testGetAllCourses() {
		
		
		//Given
		Course c1 = new Course("English", "Anderea Scamaden");
		c1.setcId(1);
		Course c2 = new Course("Mathematics", "Eustace Niemetz");
		c2.setcId(2);
		Course c3 = new Course("Anatomy", "Reynolds Pastor");
		c3.setcId(3);
		Course c4 = new Course("Organic Chemistry", "Odessa Belcher");
		c4.setcId(4);
		Course c5 = new Course("Physics", "Dani Swallow");
		c5.setcId(5);
		Course c6 = new Course("Digital Logic", "Glenden Reilingen");
		c6.setcId(6);
		Course c7 = new Course("Object Oriented Programming", "Giselle Ardy");
		c7.setcId(7);
		Course c8 = new Course("Data Structures", "Carolan Stoller");
		c8.setcId(8);
		Course c9 = new Course("Politics", "Carmita De Maine");
		c9.setcId(9);
		Course c10 = new Course("Art", "Kingsly Doxsey");
		c10.setcId(10);
		
		List<Course> expected = new ArrayList<>();
		expected.add(c1);
		expected.add(c2);
		expected.add(c3);
		expected.add(c4);
		expected.add(c5);
		expected.add(c6);
		expected.add(c7);
		expected.add(c8);
		expected.add(c9);
		expected.add(c10);
		
				
		//When
		List<Course> actual = csrv.getAllCourses(session);
		System.out.println(actual.toString());
		
		//Then
		assertEquals(expected.get(1), actual.get(1));
		

	}
}
