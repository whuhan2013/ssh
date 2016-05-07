package cn.itcast.spring.sh.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.spring.sh.createobject.method.HelloWorld;
import cn.itcast.spring.sh.createobject.method.HelloWorldFactory;


public class CreateObjectMethodTest {
	@Test
	public void testCreateObjectMethod_DefaultConstructor(){
		/**
		 * 1、启动spring容器
		 * 2、从spring容器中把对象取出来
		 * 3、对象调用方法
		 */
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloWorld helloWorld = (HelloWorld)context.getBean("helloWorld_C_M");
		helloWorld.hello();
	}
	
	@Test
	public void testCreateObjectMethod_Factory(){
		/**
		 * 1、启动spring容器
		 * 2、从spring容器中把对象取出来
		 * 3、对象调用方法
		 */
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloWorld factory = (HelloWorld)context.getBean("aa");
		factory.hello();
	}
}
