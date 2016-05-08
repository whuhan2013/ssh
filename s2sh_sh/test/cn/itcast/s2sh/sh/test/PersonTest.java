package cn.itcast.s2sh.sh.test;

import org.junit.Test;

import cn.itcast.s2sh.domain.sh.Person;
import cn.itcast.s2sh.sh.service.PersonService;
import cn.itcast.s2sh.sh.utils.SpringInit;

public class PersonTest extends SpringInit{
	@Test
	public void testSavePerson(){
		PersonService personService = (PersonService)context.getBean("personService");
		Person person = new Person();
		person.setPname("aaa");
		personService.savePerson(person);
	}
}
