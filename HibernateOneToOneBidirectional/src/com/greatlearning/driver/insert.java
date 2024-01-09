package com.greatlearning.driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.greatlearning.entity.Address;
import com.greatlearning.entity.Student;


public class insert {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Address.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// create the objects
			Student tempStudent = new Student("rucha", "wagh", "ruchwagh@greatlearning.com");

			Address tempAddress = new Address("Maharashtra","Mumbai");

			// associate the objects
			tempStudent.setStudentAddress(tempAddress);
		

			// start transaction
			session.beginTransaction();

			// save the student
			session.save(tempStudent);
			

			// commit transaction
			session.getTransaction().commit();

		} finally {
			factory.close();
			session.close();

		}
	}
}
