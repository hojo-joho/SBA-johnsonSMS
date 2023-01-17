package com.johnson.maven.jpa.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SmsUtil {
	
	public static Session getConnection() {
		Configuration configuration = new Configuration();
		SessionFactory factory = configuration.configure().buildSessionFactory();
		Session session = factory.openSession();
		return session;
	}

	public static void closeSession (Session session) {
		session.close();
	}
}
