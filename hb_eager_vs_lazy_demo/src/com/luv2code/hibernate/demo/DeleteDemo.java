package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteDemo {

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
			int theId=2;
			Instructor temp=session.get(Instructor.class, theId);
			System.out.println("Found Instructor:"+temp);
			
			if(temp!=null)
			{
				System.out.println("bas delete");
				// will delete from instructor_detail
				session.delete(temp);
			}
			session.getTransaction().commit();
			System.out.println("SuccessFul");
		}
		finally {
			factory.close();
		}
	}

}





