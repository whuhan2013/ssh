package cn.itcast.spring.sh.test;

import org.junit.Test;

import cn.itcast.spring.sh.di.constructor.Person;
import cn.itcast.spring.sh.utils.SpringInit;

public class DISetTest extends SpringInit{
	@Test
	public void testSet(){
		Person person  = (Person)context.getBean("person_Con");
		System.out.println(person.getPname());
		person.getStudent().student();
	}
}
