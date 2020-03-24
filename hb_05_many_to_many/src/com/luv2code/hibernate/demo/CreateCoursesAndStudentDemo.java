package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCoursesAndStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			session.beginTransaction();
			
			Course tempCourse=new Course("How to score million points");
			
			System.out.println("sabing the course!1!");
			session.save(tempCourse);
			System.out.println("Successfully Saved");
			
			Student temp1=new Student("Shikha","MAurya","abc@gmail.com");
			Student temp2=new Student("Aman","MAurya","abc@aman.com");
			
			tempCourse.addStudent(temp1);
			tempCourse.addStudent(temp2);
			
			System.out.println("Saving Students");
			session.save(temp1);
			session.save(temp2);
			System.out.println("saved students: "+tempCourse);
			
			session.getTransaction().commit();
			System.out.println("SuccessFul");
		}
		finally {
			session.close();
			factory.close();
		}
	}

}





