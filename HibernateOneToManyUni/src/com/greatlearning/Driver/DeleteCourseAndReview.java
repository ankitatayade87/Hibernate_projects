package com.greatlearning.Driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.greatlearning.entity.Course;
import com.greatlearning.entity.Review;
import com.greatlearning.entity.Teacher;
import com.greatlearning.entity.TeacherDetails;

public class DeleteCourseAndReview {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Teacher.class)
				.addAnnotatedClass(TeacherDetails.class)
				.addAnnotatedClass(Course.class)
				 .addAnnotatedClass(Review.class)
				 .buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			int theCourseId=108;
			// start transaction
			session.beginTransaction();

			Course tempCourse = session.get(Course.class,theCourseId);
			
			if(tempCourse!=null) {
				System.out.println("Deleting : "+ tempCourse);
				
				//Note!! : it will not delete Teacher data 
			    //         as we have not provided CascadeType.ALL
				session.delete(tempCourse);
			}
			
			

			// commit transaction
			session.getTransaction().commit();

		} finally {
			factory.close();
		}
	}
}
