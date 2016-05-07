package cn.itcast.spring.sh.test;

import org.junit.Test;

import cn.itcast.spring.sh.mvc.PersonAction;
import cn.itcast.spring.sh.utils.SpringInit;

public class MVCTest extends SpringInit{
	@Test
	public void test(){
		PersonAction personAction = (PersonAction)context.getBean("personAction");
		personAction.savePerson();
	}
}
