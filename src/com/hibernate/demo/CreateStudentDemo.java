package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.hibernate.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) 
	{
			
		//Create SessionFactory
		SessionFactory factory=new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//Create Session
		Session  session=factory.getCurrentSession();
		
		try
		{
		
			
			//Create a student object
			Student newStudent=new Student ("Amit","Mishra","amitmishraph@gmail.com");
			System.out.println("Creating new student Object");
			
			//start a transaction
			session.beginTransaction();
			
			//Save the student to database table
			session.save(newStudent);
			System.out.println("Saving the Student..");
			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!!");
		}
		finally
		{
			factory.close();
		}
	}
	

	}
