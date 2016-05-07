package cn.itcast.jdkproxy.hibernate.sh;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PersonDaoInterceptor implements InvocationHandler{
	private Object target;
	private MyTransaction myTransaction;
	
	public PersonDaoInterceptor(Object target,MyTransaction myTransaction){
		this.target = target;
		this.myTransaction = myTransaction;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("aaaaaaaaaaaaaaa");
		if(method.getName().equals("")){
			this.myTransaction.beginTransaction();
			Object obj = method.invoke(this.target, args);
			this.myTransaction.commit();
		}else{
			Object obj = method.invoke(this.target, args);
		}
		
		System.out.println("bbbbbbbbbbbbbbbb");
		return null;
	}
	
	
}
