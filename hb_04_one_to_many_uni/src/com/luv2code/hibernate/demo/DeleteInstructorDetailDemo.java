package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			session.beginTransaction();
			int theId=5;
			InstructorDetail tempID=session.get(InstructorDetail.class, theId);
			Instructor temp=tempID.getInstructor();
			
			System.out.println("Found Instructor: "+temp);
			System.out.println("Found InstructorDetail: "+tempID);
			tempID.getInstructor().setInstructorDetail(null);
			session.delete(tempID);
			session.getTransaction().commit();
			System.out.println("SuccessFul");
		}
		catch(Exception exc)
		{
			exc.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}





