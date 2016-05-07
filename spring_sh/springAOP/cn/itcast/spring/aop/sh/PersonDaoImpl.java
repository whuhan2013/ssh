package cn.itcast.spring.aop.sh;

import java.lang.reflect.Method;

import org.junit.Test;

import cn.itcast.spring.aop.annotation.sh.HibernateUtils;
import cn.itcast.spring.aop.annotation.sh.Person;

public class PersonDaoImpl extends HibernateUtils{
	public String savePerson(Person person) {
		// TODO Auto-generated method stub
		//int a = 1/0;
		//sessionFactory.getCurrentSession().save(person);
		System.out.println("aaaa");
		return "aaaa";
	}
}
