package co.greatlearning.service;
import com.greatlearning.entity.Teacher;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateTeacher {
	
	public static void main(String[] args) {
			
		SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Teacher.class)
                .buildSessionFactory();


		Session session = factory.getCurrentSession();
		
		try
		{
			session.beginTransaction();
			
			session.createQuery("update Teacher set f_Name = 'Sonu' where f_name = 'Adarsh'").executeUpdate();
			
			session.getTransaction().commit();
			
			System.out.println("Updating done..");
			
		}
		finally {
			
			session.close();
			factory.close();
		}

	}
}
