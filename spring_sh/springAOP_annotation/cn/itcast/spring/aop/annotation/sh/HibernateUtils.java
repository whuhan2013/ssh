package cn.itcast.spring.aop.annotation.sh;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	public static SessionFactory sessionFactory;
	static{
		Configuration configuration = new Configuration();
		configuration.configure("cn/itcast/spring/aop/annotation/sh/hibernate.cfg.xml");
		sessionFactory = configuration.buildSessionFactory();
	}
}
