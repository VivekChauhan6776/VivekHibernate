package com.hibernate;

import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.model.Employee;

public class Main {

	public static void main(String[] args) {

		Employee vivek = new Employee(3,"vivek", "male", 7363); 
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(vivek);
		tx.commit();
		

	}

}
