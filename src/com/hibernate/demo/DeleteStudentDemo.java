package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.hibernate.entity.Student;

public class DeleteStudentDemo {

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
		
	
			
			
			//Deleting student with id of 7
		session.createQuery("Delete from Student where id=7").executeUpdate();
			
			
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
