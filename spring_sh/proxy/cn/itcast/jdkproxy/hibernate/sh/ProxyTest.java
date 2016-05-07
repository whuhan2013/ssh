package cn.itcast.jdkproxy.hibernate.sh;

import java.lang.reflect.Proxy;

import org.junit.Test;

public class ProxyTest {
	@Test
	public void test(){
		Object target = new PersonDaoImpl();
		MyTransaction myTransaction = new MyTransaction();
		PersonDaoInterceptor interceptor = new PersonDaoInterceptor(target, myTransaction);
		PersonDao personDao = (PersonDao)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),interceptor);
		Person person = new Person();
		person.setPname("aa");
		String s = (String)personDao.savePerson(person);
		System.out.println(s);
	}
}
