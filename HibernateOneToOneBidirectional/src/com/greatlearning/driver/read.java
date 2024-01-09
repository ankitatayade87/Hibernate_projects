package com.greatlearning.driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.greatlearning.entity.Address;
import com.greatlearning.entity.Student;

public class read {
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

			// start transaction
			session.beginTransaction();
			
			// get the address object
			int tempAddressId=2;
			Address tempAddress=session.get(Address.class, tempAddressId);

			
			// Print the Address
			System.out.println("Address Details : " +tempAddress);
						
			//print the associated student values
			System.out.println("Associated Student : "+ tempAddress.getStudent());
			

			// commit transaction
			session.getTransaction().commit();

		} finally {
 			factory.close();
 			session.close();
		}
	}
}
