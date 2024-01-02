package co.greatlearning.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.greatlearning.entity.Teacher;
import java.util.List;

public class QueryTeacher {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Teacher.class).
				buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			
			session.beginTransaction();
			
			List<Teacher> tmpTeacher = session.createQuery("from Teacher").list();
			
			session.getTransaction().commit();	
			
			System.out.println(tmpTeacher);
			
			
		}
		finally {
			
			session.close();
			factory.close();
		}

	}

}
