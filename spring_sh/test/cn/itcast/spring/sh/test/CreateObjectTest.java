package cn.itcast.spring.sh.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.spring.sh.ioc.createobject.HelloWorld;

public class CreateObjectTest {
	@Test
	public void testCreateObject(){
		/**
		 * 1、启动spring容器
		 * 2、从spring容器中把对象取出来
		 * 3、对象调用方法
		 */
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloWorld helloWorld = (HelloWorld)context.getBean("helloWorld");
		helloWorld.hello();
	}
}
