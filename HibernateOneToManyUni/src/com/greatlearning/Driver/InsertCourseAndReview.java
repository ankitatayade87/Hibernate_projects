
package com.greatlearning.Driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.greatlearning.entity.Course;
import com.greatlearning.entity.Review;
import com.greatlearning.entity.Teacher;
import com.greatlearning.entity.TeacherDetails;
public class InsertCourseAndReview {

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

			//start a transaction
			session.beginTransaction();

			// create the objects
			Course tempCourse = new Course("python2");

			//add some review
			tempCourse.addReview(new Review("Good Course"));
			tempCourse.addReview(new Review(" Really loved it"));
			tempCourse.addReview(new Review("Awesome"));
			tempCourse.addReview(new Review("Something Valuable"));

			//save course and leverage the cascade all
			System.out.println("Saving Course");
			System.out.println(tempCourse);
			System.out.println(tempCourse.getReviews());
			session.save(tempCourse);

			//commit transaction
			session.getTransaction().commit();

			System.out.println("Done");

		} finally {
			//add a clean up code
			session.close();

			factory.close();
		}
	}
}


