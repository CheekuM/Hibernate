package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateDemo {

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
			Instructor temp=new Instructor("Sakshi","Singh","hello@gm.com");
			InstructorDetail tempID=new InstructorDetail("abs@kuccho","dancing");
			
			temp.setInstructorDetail(tempID);
			session.beginTransaction();
			session.save(temp);
			session.getTransaction().commit();
			System.out.println("SuccessFul");
		}
		finally {
			factory.close();
		}
	}

}




