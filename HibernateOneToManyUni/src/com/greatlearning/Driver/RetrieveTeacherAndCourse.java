
package com.greatlearning.Driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.greatlearning.entity.Course;
import com.greatlearning.entity.Teacher;
import com.greatlearning.entity.TeacherDetails;


public class RetrieveTeacherAndCourse {


	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Teacher.class)
				.addAnnotatedClass(TeacherDetails.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start transaction
			session.beginTransaction();

			//get the Teacher
			int theId = 10;
			Teacher tempTeacher =session.get(Teacher.class,theId);
			System.out.println("Teacher :" + tempTeacher);
			
			//get courses of Teacher (tempTeacher)
			System.out.println("Courses "+tempTeacher.getCourses());

			session.getTransaction().commit();

			System.out.println("Completed Successfully");



		} finally {
			//add a clean up code
			session.close();

			factory.close();
		}
	}
}


