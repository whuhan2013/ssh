package cn.itcast.spring.aop.sh.aspects;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SalaryTest {
	@Test
	public void test(){
		ApplicationContext context = new ClassPathXmlApplicationContext("cn/itcast/spring/aop/sh/aspects/applicationContext.xml");
		SalaryManagerImpl proxy = (SalaryManagerImpl) context.getBean("salaryManager");
		proxy.showSalary();
	}
}
