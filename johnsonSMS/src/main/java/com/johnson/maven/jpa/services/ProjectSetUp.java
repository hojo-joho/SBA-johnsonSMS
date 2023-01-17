package com.johnson.maven.jpa.services;


import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import com.johnson.maven.jpa.models.Course;
import com.johnson.maven.jpa.models.Student;

public class ProjectSetUp {

	public void setUp(Session session) {

		Course c1 = new Course("English", "Anderea Scamaden");
		Course c2 = new Course("Mathematics", "Eustace Niemetz");
		Course c3 = new Course("Anatomy", "Reynolds Pastor");
		Course c4 = new Course("Organic Chemistry", "Odessa Belcher");
		Course c5 = new Course("Physics", "Dani Swallow");
		Course c6 = new Course("Digital Logic", "Glenden Reilingen");
		Course c7 = new Course("Object Oriented Programming", "Giselle Ardy");
		Course c8 = new Course("Data Structures", "Carolan Stoller");
		Course c9 = new Course("Politics", "Carmita De Maine");
		Course c10 = new Course("Art", "Kingsly Doxsey");

		session.save(c1);
		session.save(c2);
		session.save(c3);
		session.save(c4);
		session.save(c5);
		session.save(c6);
		session.save(c7);
		session.save(c8);
		session.save(c9);
		session.save(c10);


		Set<Course> cList1 = new HashSet<Course>();
		cList1.add(c10);
		cList1.add(c8);
		cList1.add(c1);

		Set<Course> cList2 =new HashSet<Course>();
		cList2.add(c2);
		cList2.add(c9);
		cList2.add(c3);

		Set<Course> cList3 = new HashSet<Course>();
		cList3.add(c4);
		cList3.add(c8);
		cList3.add(c6);

		Set<Course> cList4 = new HashSet<Course>();
		cList4.add(c2);
		cList4.add(c7);
		cList4.add(c5);

		Set<Course> cList5 = new HashSet<Course>();
		cList5.add(c6);
		cList5.add(c8);
		cList5.add(c9);
		
		Student s1 = new Student("hluckham0@google.ru", "Hazel Luckham", "X1uZcoIh0dj", cList1);
		Student s2 = new Student("sbowden1@yellowbook.com", "Sonnnie Bowden", "SJc4aWSU", cList1);
		Student s3 = new Student("qllorens2@howstuffworks.com", "Quillan Llorens", "W6rJuxd", cList2);
		Student s4 = new Student("cstartin3@flickr.com", "Clem Startin", "XYHzJ1S", cList2);
		Student s5 = new Student("tattwool4@biglobe.ne.jp", "Thornie Attwool", "Hjt0SoVmuBz", cList3);
		Student s6 = new Student("hguerre5@deviantart.com", "Harcourt Guerre", "OzcxzD1PGs", cList3);
		Student s7 = new Student("htaffley6@columbia.edu", "Holmes Taffley", "xowtOQ", cList4);
		Student s8 = new Student("aiannitti7@is.gd", "Alexandra Iannitti", "TWP4hf5j", cList4);
		Student s9 = new Student("ljiroudek8@sitemeter.com", "Laryssa Jiroudek", "bXRoLUP", cList5);
		Student s10 = new Student("cjaulme9@bing.com", "Cahra Jaulme", "FnVklVgC6r6", cList5);

		session.save(s1);
		session.save(s2);
		session.save(s3);
		session.save(s4);
		session.save(s5);
		session.save(s6);
		session.save(s7);
		session.save(s8);
		session.save(s9);
		session.save(s10);

	}

}
