package cn.itcast.spring.jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonTest {
	@Test
	public void test(){
		ApplicationContext context = new ClassPathXmlApplicationContext("cn/itcast/spring/jdbc/applicationContext.xml");
		PersonDao personDao = (PersonDao)context.getBean("personDao");
		personDao.query();
	}
}
