package cn.itcast.spring.sh.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.spring.sh.createobject.when.HelloWorld;


public class CreateObjectWhenTest {
	@Test
	public void testWhen(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println("aa");
		HelloWorld helloWorld =(HelloWorld) context.getBean("helloWhen");
		helloWorld.hello();
	}
}
