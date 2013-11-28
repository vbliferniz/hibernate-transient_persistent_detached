/**
 * 
 */
package com.bliferniz.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bliferniz.dto.UserDetails;

public class HibernateTest {

	private static final SessionFactory factory = new Configuration().configure().buildSessionFactory();
	
	public static void main(String[] args) {

		//Transient
		UserDetails user = new UserDetails();
		user.setUserName("Soan Poal");

		Session session = factory.openSession();
		session.beginTransaction();
		
		//Persistent
		session.save(user); //Insert the new Data into the DB
		 
		//Transient
		user.setUserName("Updated user"); // will not be updated
		
		//Persistent
		user.setUserName("Updated user again"); //Hibernate updates the data automatically in the DB, before of that Hibernate looks for the last
												//change of the object which must be saved.
		
		
		session.getTransaction().commit();
		session.close();
		
		//Detached
		user.setUserName("Updated user after session close"); 
	}
	
}
