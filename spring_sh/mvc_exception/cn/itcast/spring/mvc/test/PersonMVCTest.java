package cn.itcast.spring.mvc.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.spring.mvc.exception.action.PersonAction;

public class PersonMVCTest {
	@Test
	public void test() throws Exception{
		ApplicationContext context = new ClassPathXmlApplicationContext("cn/itcast/spring/mvc/config/applicationContext.xml");
		PersonAction personAction = (PersonAction)context.getBean("personAction");
		personAction.savePerson();
	}
}
