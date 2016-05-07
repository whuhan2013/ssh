package cn.itcast.spring.aop.sh;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	public static SessionFactory sessionFactory;
	static{
		Configuration configuration = new Configuration();
		configuration.configure("cn/itcast/spring/aop/sh/hibernate.cfg.xml");
		sessionFactory = configuration.buildSessionFactory();
	}
}
