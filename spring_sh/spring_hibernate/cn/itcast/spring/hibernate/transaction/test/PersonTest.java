package cn.itcast.spring.hibernate.transaction.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.spring.hiberante.transaction.domain.Person;
import cn.itcast.spring.hibernate.transaction.service.PersonService;

public class PersonTest {
	@Test
	public void test(){
		ApplicationContext context =  new ClassPathXmlApplicationContext("cn/itcast/spring/hibernate/transaction/config/applicationContext.xml");
		PersonService personService = (PersonService)context.getBean("personService");
		Person person = new Person();
		person.setPname("a");
		personService.savePerson(person);
	}
}
