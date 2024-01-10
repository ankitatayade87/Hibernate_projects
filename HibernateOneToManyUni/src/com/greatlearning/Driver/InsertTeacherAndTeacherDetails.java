package com.greatlearning.Driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.greatlearning.entity.Course;
import com.greatlearning.entity.Review;
import com.greatlearning.entity.Teacher;
import com.greatlearning.entity.TeacherDetails;

public class InsertTeacherAndTeacherDetails {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				                 .configure("hibernate.cfg.xml")
				                 .addAnnotatedClass(Teacher.class)
				                 .addAnnotatedClass(TeacherDetails.class)
				                 .addAnnotatedClass(Course.class)
				                 .addAnnotatedClass(Review.class)
				                 .buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// create the objects
			Teacher theTeacher = new Teacher("Amy","Suri", "Amy@gl.com");
			
			TeacherDetails theTeacherDetails = new TeacherDetails("Mumbai","Playing Games");
			
			//associate the object
			theTeacher.setTeacherDetails(theTeacherDetails);

			// start transaction
			session.beginTransaction();

			// save the teacher
		    System.out.println("Saving the Teacher: "+ theTeacher);
		    session.save(theTeacher);

			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Completed Successfully");

			
			
		} finally {
			//add a clean up code
			session.close();
			
			factory.close();
		}
	}
}
