package cn.itcast.spring.sh.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.spring.sh.scope.HelloWorld;


public class ScopeTest {
	@Test
	public void testScope(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println("asfdadsfasfdasdfasdf");
		HelloWorld helloWorld = (HelloWorld) applicationContext.getBean("helloScope");
		
		helloWorld.getStringS().add("sss");
		
		HelloWorld helloWorld2 = (HelloWorld) applicationContext.getBean("helloScope");
		helloWorld2.getStringS().add("aaa");
		System.out.println(helloWorld.getStringS().size());
		System.out.println(helloWorld);
		System.out.println(helloWorld2);
	}
}
