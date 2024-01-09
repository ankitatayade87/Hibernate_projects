package com.greatlearning.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.greatlearning.entity.Student;
import com.greatlearning.entity.StudentAddress;

public class Insert {
	
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
			Student tmpStudent = new Student("Chinmay", "Dixit", "chinmaydixit23@gmail.com");
			
			StudentAddress studentAddressDetails = new StudentAddress("pune", "Maharashtra");
			
			tmpStudent.setStudentAddressDetails(studentAddressDetails);
			
			session.beginTransaction();
			
			session.save(tmpStudent);
			
			session.getTransaction().commit();
			
			System.out.println("Transaction Done..");
			
		}
		finally {
			
			session.close();
			factory.close();
			
		}


	}

}
