package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.hibernate.entity.Student;

public class UpdateStudentDemo {

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
		
			
			//start a transaction
			session.beginTransaction();
			
			int studentId=4;
			//retreive student with id =4
			Student myStudent=session.get(Student.class,studentId);
			
			
			//updating the student name with id =4 as maxWELL
			myStudent.setFirstName("MAXWELL");
			
	
			
			
			//Updating with execute update
			session.createQuery("update Student set lastName='Jain' where id=7").executeUpdate();
			
			
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
