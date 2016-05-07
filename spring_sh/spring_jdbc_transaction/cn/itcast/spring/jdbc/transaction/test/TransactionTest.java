package cn.itcast.spring.jdbc.transaction.test;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.spring.jdbc.transaction.sh.service.PersonService;

public class TransactionTest {
	public static ApplicationContext context;
	static{
		context = new ClassPathXmlApplicationContext("cn/itcast/spring/jdbc/transaction/config/applicationContext.xml");
	}
	@Test
	public void testDataSource(){
		DataSource dataSource = (DataSource)context.getBean("dataSource");
		System.out.println(dataSource);
	}
	
	@Test
	public void testPesonDao(){
		context.getBean("personDao");
	}
	
	@Test
	public void testPersonService(){
		PersonService personService = (PersonService)context.getBean("personService");
		personService.savePerson();
	}
}
