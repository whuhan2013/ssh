package cn.itcast.sh.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HiberanteUtils {
	public static SessionFactory sessionFactory;
	static{
		Configuration configuration = new Configuration();
		configuration.configure();
		sessionFactory = configuration.buildSessionFactory();
	}
}
