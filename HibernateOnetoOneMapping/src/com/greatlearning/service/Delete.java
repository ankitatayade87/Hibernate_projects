package com.greatlearning.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.greatlearning.entity.Student;
import com.greatlearning.entity.StudentAddress;

public class Delete {
	
	public static void main(String[] args) {
		
//		SessionFactory factory = new Configuration().
//									configure("hibernate.cfg.xml").
//									addAnnotatedClass(Student.class).
//									addAnnotatedClass(StudentAddress.class).
//									buildSessionFactory();
		
		SessionFactory factory = new Configuration()
                					.configure("hibernate.cfg.xml")
                					.addAnnotatedClass(Student.class)
                					.addAnnotatedClass(StudentAddress.class)
                					.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
//			session.createQuery("delete from Student where id = 2").executeUpdate();
			
			Student tmpStudent = session.get(Student.class, 3);
			
			session.delete(tmpStudent);
			
			session.getTransaction().commit();
			
			System.out.println("Transaction Done..");
			
		}
		finally {
			
			session.close();
			factory.close();
			
		}


	}

}
