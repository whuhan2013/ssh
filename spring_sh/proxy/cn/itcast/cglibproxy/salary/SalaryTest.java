package cn.itcast.cglibproxy.salary;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SalaryTest {
	@Test
	public void test(){
		Object target = new SalaryManagerImpl();
		Logger logger = new Logger();
		Security security = new Security();
		Privilege privilege = new Privilege();
		List<Interceptor> interceptors = new ArrayList<Interceptor>();
		interceptors.add(logger);
		interceptors.add(security);
		interceptors.add(privilege);
		SalaryInterceptor interceptor = new SalaryInterceptor(target, interceptors);
		SalaryManagerImpl proxy = (SalaryManagerImpl)interceptor.createProxy();
		proxy.showSalary();
	}
}
