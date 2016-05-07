package cn.itcast.proxy.sh;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProxyTest {
	@Test
	public void test(){
		ApplicationContext context = new ClassPathXmlApplicationContext("cn/itcast/proxy/sh/applicationContext-proxy.xml");
		PersonDao personDao = (PersonDao)context.getBean("personDao2");
		personDao.deletePerson();
	}
}
