package cn.itcast.spring.sh.test;

import org.junit.Test;

import cn.itcast.spring.annotation.di.Person;
import cn.itcast.spring.sh.utils.SpringInit;

public class AnnotationTest extends SpringInit{
	@Test
	public void testPerson(){
		Person person = (Person)context.getBean("person_annotation");
		person.showStudent();
	}
}
