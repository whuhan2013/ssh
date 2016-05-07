package cn.itcast.jdkproxy.salary;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

public class SalaryInterceptor implements InvocationHandler{

	
	private Object target;
	
	private List<Interceptor> interceptors;
	
	public SalaryInterceptor(Object target,List<Interceptor> interceptors){
		this.target = target;
		this.interceptors = interceptors;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		for(Interceptor interceptor:interceptors){
			interceptor.interceptor();
		}
		method.invoke(this.target, args);
		return null;
	}

}
