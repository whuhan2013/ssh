package cn.itcast.spring.aop.annotation.sh;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class PersonTest {
	@Test
	public void test(){
		ApplicationContext context = new ClassPathXmlApplicationContext("cn/itcast/spring/aop/annotation/sh/applicationContext.xml");
		PersonDaoImpl personDao = (PersonDaoImpl)context.getBean("personDao");
		Person person = new Person();
		person.setPname("aaas");
		personDao.savePerson(person);
	}
}
