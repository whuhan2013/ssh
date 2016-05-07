package cn.itcast.jdkproxy.sh;

import java.lang.reflect.Proxy;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProxyTest {
	@Test
	public void test(){
		Object target = new PersonDaoImpl();
		Transaction transaction = new Transaction();
		PersonInterceptor interceptor = new PersonInterceptor(target, transaction);
		/**
		 * 1、目标类的类加载器
		 * 2、目标类实现的所有的接口
		 * 3、拦截器
		 */
		PersonDao personDao = (PersonDao)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), interceptor);
		personDao.deletePerson();
	}
}
