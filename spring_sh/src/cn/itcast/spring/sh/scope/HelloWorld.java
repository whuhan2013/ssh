package cn.itcast.spring.sh.scope;

import java.util.ArrayList;
import java.util.List;

public class HelloWorld {
	/**
	 * 该list是一个共享的数据
	 */
	private List<String> stringS = new ArrayList<String>();
	public List<String> getStringS() {
		return stringS;
	}
	public void setStringS(List<String> stringS) {
		this.stringS = stringS;
	}
	public HelloWorld(){
		System.out.println("++++++++++++");
	}
	public void hello(){
		System.out.println("hello");
	}
}
