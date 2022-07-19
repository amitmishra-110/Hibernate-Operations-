package com.hibernate.demo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.hibernate.entity.Student;

public class PrimaryKeyDemo {
	
	//adding @GeneratedValue(strategy=GenerationType.IDENTITY) TO id variable
	//SAME CONSTRAINT AS GIVEN IN DATABASE COLUMN 
	
	public static void main(String[] args)
	{
		
		//Create SessionFactory
		
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		//create Session Object
		Session session=factory.getCurrentSession();
		
		try
		{
			
		//create Student object	
		Student sumit=new Student("Sumit","Mishra","sumit@gmail.com");
		Student suman=new Student("Suman","Mishra","suman@gmail.com");
		Student deepa=new Student("Deepa","Singh","Deepa@gmail.com");
		
		System.out.println("Saving 3 students in database");
					
		//start transaction		
		session.beginTransaction();
			
		//save the student
		session.save(sumit);
		session.save(suman);
		session.save(deepa);
		System.out.println("Saving the Student");
			
		//commit the transaction
		session.getTransaction().commit();		
			
	}
		finally
		
		{
			
			factory.close();
		}
		
		
		
		
		
	}

}
