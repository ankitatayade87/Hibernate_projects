package co.greatlearning.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.greatlearning.entity.Teacher;

public class DeleteTeacher {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Teacher.class).
				buildSessionFactory();

		Session session = factory.getCurrentSession();

		try 
		{
			session.beginTransaction();
			
			session.createQuery("delete from Teacher where id = 2").executeUpdate();
			
			session.getTransaction().commit();
			
			System.out.println("Deleted object from table Teacher.");
			
		}

		finally
		{
			session.close();
			factory.close();

		}

	}

}
