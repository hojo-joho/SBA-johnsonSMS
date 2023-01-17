package com.johnson.maven.johnsonSMS;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.johnson.maven.jpa.models.Course;
import com.johnson.maven.jpa.models.Student;
import com.johnson.maven.jpa.services.CourseService;
import com.johnson.maven.jpa.services.ProjectSetUp;
import com.johnson.maven.jpa.services.SmsUtil;
import com.johnson.maven.jpa.services.StudentService;


public class App 
{
	static Session session = SmsUtil.getConnection();
	static Transaction transaction = session.beginTransaction();

	private Scanner input;
	private StudentService studentSrv;
	private CourseService courseSrv;
	private Student student;
	
	public App() {
	input = new Scanner(System.in);
	studentSrv = new StudentService();
	courseSrv = new CourseService();
	}

	
    public static void main( String[] args ){

    	/**
    	 * The start object and setup method should be commented out after running the app the first time. 
    	 * 
    	 * After first run:
    	 * 1) comment out lines 47 and 48 (ProjectSetU... and start.setUp...)
    	 * 2) uncomment lines 50 and 52 (App sms... and sms.runWelcom...)
    	 * 3) Run app again 
    	 */
    	
    	ProjectSetUp start = new ProjectSetUp();
    	start.setUp(session);
    	
//    	App sms = new App();
//
//    	sms.runWelcomeMenu(session);
    	
    	transaction.commit();    
    	session.close();

    		}

    
    		/**
    		 * This is the entrypoint to workflow.
    		 * A user can either login or quit
    		 * @param session
    		 */
			private void runWelcomeMenu(Session session) {

    			System.out.println("Are you a Student?");
    			System.out.println();
    			System.out.println("1. Yes, continue to login");
    			System.out.println("2. Cancel");

    			while (true) {
    				int choice = input.nextInt();
    				String email;
    				String password;
    				Set<Course> courses;

    				switch (choice) {
    				case 1:
    					input.nextLine();
    					System.out.println("Enter your email:");
    					email = input.nextLine();
    					System.out.println();
    					System.out.println("Enter your password:");
    					password = input.nextLine();
    					System.out.println();

    					if (studentSrv.validateStudent(session, email, password)) {

    						student = studentSrv.getStudentByEmail(session, email);
    						System.out.println("Student is valid");

    							try {
    								courses = studentSrv.getStudentCourses(session, email);

    								System.out.println();

    								if (courses.size() != 0) {
    									System.out.println("Your Courses: ");
    									System.out.println("Course ID | Name | Instructor");
    								}

    								for (Course c : courses) {
    									System.out.println(c.getcId() + " " + c.getcName() + " " + c.getcInstructorName());
    								}
    							} catch (Exception e) {
    								System.out.println();
    								System.out.println("You are not registered for any courses");
    							} finally {
    								runMainMenu(session);
    							}}

    				case 2:
    					System.out.println("Goodbye");
    					session.close();
    					input.close();
    					System.exit(0);
    				}
    			}
    		}
			
			/**
			 * This is the menu after a successful login
			 * A user can either register for a new course or logout.
			 * @param session
			 */
    		private void runMainMenu(Session session) {

    			int choice = 0;
    			System.out.println();
    			System.out.println("What would you like to do?");
    			System.out.println();
    			System.out.println("1. Register for a course");
    			System.out.println("2. Logout");

    			while (true) {
    				choice = input.nextInt();

    				switch (choice) {
    				case 1:
    					runRegistrationMenu(session);
    					break;
    				case 2:
    					System.out.println("You have logged out");
    					session.close();
    					input.close();
    					System.exit(0);
    				}
    			}

    		}
    		
    		/**
    		 * This will display the courses to choose from and a student can register for a new course
    		 * It is a Set so there will not be duplicates in their courses
    		 * @param session
    		 */
    		public void runRegistrationMenu(Session session) {

    			List<Course> allCourses = courseSrv.getAllCourses(session);

    			System.out.println("All Courses:");
    			System.out.println("ID | Name | Instructor");
    			for (Course c : allCourses) {
    				System.out.println(c.getcId() + " " + c.getcName() + " " + c.getcInstructorName());
    			}
    			
    			System.out.println();
    			System.out.println("What is the ID of the course you want to register for?");
    			int choice = input.nextInt()-1;

    			
    			studentSrv.registerStudentToCourse(session, student, allCourses, choice);

    			Set<Course> updatedCourseList = new HashSet<Course>(studentSrv.getStudentCourses(session, student.getsEmail()));
    			
    			System.out.println("updated:");
    			System.out.println("Your Courses:");
    			System.out.println("ID | Name | Instructor");
    			for (Course c : updatedCourseList) {
    				System.out.println(c.getcId() + " " + c.getcName() + " " + c.getcInstructorName());
    			}
    			
    			runMainMenu(session);
    }
}
