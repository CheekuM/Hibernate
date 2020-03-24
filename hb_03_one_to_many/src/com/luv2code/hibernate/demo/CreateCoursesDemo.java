package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCoursesDemo {

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
			
			Course tempCourse1=new Course("Air Guitar - The Ultimate Guide");
			Course tempCourse2=new Course("The PinBall MasterClass");
			
			temp.add(tempCourse1);
			temp.add(tempCourse2);
			
			session.save(tempCourse1);
			session.save(tempCourse2);
			
			System.out.println("Successfully Saved");
			
			session.getTransaction().commit();
			System.out.println("SuccessFul");
		}
		finally {
			session.close();
			factory.close();
		}
	}

}





