package co.greatlearning.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.greatlearning.entity.Teacher;

public class CreateTeacher {
	
	public static void main(String[] args) {
		
		
		SessionFactory factory = new Configuration()
				                     .configure("hibernate.cfg.xml")
				                     .addAnnotatedClass(Teacher.class)
				                     .buildSessionFactory();
		
		
		Session session = factory.getCurrentSession();
		
		try {
		
			Teacher teacher1 = new Teacher(1, "Ankita", "Tayade", "ankitatayade87@gmail.com");
			
			session.beginTransaction();
			
			session.save(teacher1);
			
			System.out.println("Saved object");
			
			session.getTransaction().commit();
		}
		finally {
			
			session.close();
			factory.close();
		}
	}
	
}
