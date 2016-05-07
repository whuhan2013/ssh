package cn.itcast.spring.extend;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExtendsTest {
	@Test
	public void test(){
		ApplicationContext context = new ClassPathXmlApplicationContext("cn/itcast/spring/extend/applicationContext-extends.xml");
		PersonDao personDao = (PersonDao)context.getBean("personDao");
		personDao.show();
	}
}
