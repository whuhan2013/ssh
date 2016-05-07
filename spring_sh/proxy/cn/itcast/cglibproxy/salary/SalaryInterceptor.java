package cn.itcast.cglibproxy.salary;

import java.lang.reflect.Method;
import java.util.List;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class SalaryInterceptor implements MethodInterceptor{

	
	private Object target;
	
	private List<Interceptor> interceptors;
	
	public SalaryInterceptor(Object target,List<Interceptor> interceptors){
		this.target = target;
		this.interceptors = interceptors;
	}
	
	public Object createProxy(){
		Enhancer enhancer = new Enhancer();
		enhancer.setCallback(this);
		enhancer.setSuperclass(this.target.getClass());
		return enhancer.create();
	}

	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2,
			MethodProxy arg3) throws Throwable {
		// TODO Auto-generated method stub
		for(Interceptor interceptor:interceptors){
			interceptor.interceptor();
		}
		arg1.invoke(this.target, arg2);
		return null;
	}
	

}
