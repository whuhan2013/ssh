package cn.itcast.cglibproxy.salary;

public class Logger implements Interceptor{

	@Override
	public void interceptor() {
		// TODO Auto-generated method stub
		System.out.println("logging");
	}
	
}
