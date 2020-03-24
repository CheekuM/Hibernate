package com.luv2code.hibernate.demo;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;


public class EagerLazyDemo2 {

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
			Query<Instructor> query=session.createQuery("select i from Instructor i "+"JOIN FETCH i.courses "+"where i.id=:theInstructorId",
											Instructor.class);
			query.setParameter("theInstructorId", id);
			
			Instructor temp=query.getSingleResult();
			
			System.out.println("Instructor:"+temp);
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





