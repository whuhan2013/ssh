package cn.itcast.spring.sh.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.spring.sh.initdestroy.HelloWorld;


public class InitDestroyTest {
	@Test
	public void testInitDestroy(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		HelloWorld helloWorld = (HelloWorld)context.getBean("helloInitDestroy");
		
		helloWorld.hello();
		
		ClassPathXmlApplicationContext applicationContext = (ClassPathXmlApplicationContext)context;
		applicationContext.close();
	}
}
