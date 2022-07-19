package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.hibernate.entity.Student;

public class ReadStudentDemo {

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
			Student newStudent=new Student ("Jayesh","Shah","jayesh@gmail.com");
			System.out.println("Creating new student Object");
			
			//start a transaction
			session.beginTransaction();
			
			//Save the student to database table
			session.save(newStudent);
			System.out.println(newStudent);
			System.out.println("Saving the Student..");
			
			//find out the primary key id for new student
			System.out.println("The student id is "+newStudent.getId());
			
			
		
			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!!");
			
			

			//NEW CODE FOR RETREIVE Data from DB
			

			//Create Session
			Session  session1=factory.getCurrentSession();
			
			//start a transaction
			session1.beginTransaction();
			
			//Reading the data from table
			System.out.println("Getting the student frpm table");
			Student jayesh=session1.get(Student.class,newStudent.getId());
			System.out.println("Data Retrieve for "+jayesh);
			
			//commit the transaction
			session1.getTransaction().commit();
			
		}
		finally
		{
			factory.close();
		}
	}
	

	}
