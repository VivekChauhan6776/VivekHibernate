package com.hibernate;

import org.hibernate.cfg.Configuration;
import org.hibernate.persister.internal.StandardPersisterClassResolver;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.model.Employee;

public class Main {

	public static void main(String[] args) {

		Employee vivek = new Employee("vansh", "male", 7363); 
//		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
//		SessionFactory sf = cfg.buildSessionFactory();
//		SessionFactory sf= new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata mate = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf= mate.buildSessionFactory();
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(vivek);
		tx.commit();
		

	}

}
