package cn.itcast.spring.aop.sh;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.spring.aop.annotation.sh.Person;
import cn.itcast.spring.aop.annotation.sh.PersonDaoImpl;

public class PersonTest {
	@Test
	public void test(){
		ApplicationContext context = new ClassPathXmlApplicationContext("cn/itcast/spring/aop/sh/applicationContext.xml");
		PersonDaoImpl personDao = (PersonDaoImpl)context.getBean("personDao");
		Person person = new Person();
		person.setPname("aaas");
		personDao.savePerson(person);
	}
}
