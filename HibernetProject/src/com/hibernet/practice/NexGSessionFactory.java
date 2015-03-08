package com.hibernet.practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class NexGSessionFactory {
	private static final Configuration cfg = new Configuration();
	static{
		cfg.configure("hibernate.config.xml");
	}
	
	public static Session getSession() {
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		return session;
	}
}
