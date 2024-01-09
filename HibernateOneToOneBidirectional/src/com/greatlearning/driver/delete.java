package com.greatlearning.driver;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.greatlearning.entity.Address;
import com.greatlearning.entity.Student;

public class delete {

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
			int tempAddressId = 1;
			Address tempAddress = session.get(Address.class, tempAddressId);
			
			session.delete(tempAddress);
		

			// commit transaction
			session.getTransaction().commit();

		} finally {
 			factory.close();
 			session.close();
		}
	}
}


