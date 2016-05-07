package cn.itcast.spring.sh.test;

import org.junit.Test;

import cn.itcast.annotation.scan.Person;
import cn.itcast.spring.sh.utils.SpringInit;

public class ScanTest extends SpringInit{
	@Test
	public void testPerson(){
		Person person = (Person)context.getBean("a");
		person.showStudent();
	}
}
