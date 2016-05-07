package cn.itcast.spring.sh.createobject.method;

public class HelloWorldFactory {
	public static HelloWorld getInstance(){
		return new HelloWorld();
	}
	
	public HelloWorld getIns(){
		return new HelloWorld();
	}
}
