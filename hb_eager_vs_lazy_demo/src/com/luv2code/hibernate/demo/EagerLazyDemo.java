package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class EagerLazyDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			session.beginTransaction();
			
			int id=1;
			Instructor temp=session.get(Instructor.class,id);
			
			System.out.println("luv@code Instructor : "+ temp);
			
			//calling getter method when session is open
			System.out.println("luv@code Courses: "+temp.getCourses());

			
			session.getTransaction().commit();
			session.close();
			
			System.out.println("\nSession is Closed\n");
			
			System.out.println("luv@code Courses: "+temp.getCourses());
			
			System.out.println("SuccessFul");
		}
		finally {
			session.close();
			factory.close();
		}
	}

}





