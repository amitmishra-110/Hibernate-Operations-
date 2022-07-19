package com.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.jdbc.hibernate.entity.Student;



//Select query using various conditions
public class QueryStudentDemo {

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
			
			//query students
			List<Student> s=session.createQuery("from Student")
							.list();
			
		 
			 for(Student i:s)
				{
					System.out.println(i);
				}
			
			//query students based on condition
			 System.out.println("Working with where clause");
			List<Student> s1=session.createQuery("from Student where  firstName='suman' ").list();
			
			for(Student j:s1)
			{
				System.out.println(j);
			}
			
			//Querying table with  OR operator
			System.out.println("Working with OR Operator");
			List<Student> s2=session.createQuery("from Student  where firstName='Suman' OR lastName='Mishra'")
					.list();
			
			for(Student k :s2)
			{
				System.out.println(k);
			}
			
		
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
