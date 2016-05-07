package cn.itcast.spring.aop.annotation.sh;

import org.springframework.stereotype.Repository;


@Repository("personDao")
public class PersonDaoImpl extends HibernateUtils{
	public String savePerson(Person person) {
		// TODO Auto-generated method stub
		//int a = 1/0;
		sessionFactory.getCurrentSession().save(person);
		System.out.println("aaaa");
		return "aaaa";
	}
}
