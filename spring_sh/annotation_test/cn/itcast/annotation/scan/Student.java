package cn.itcast.annotation.scan;

import org.springframework.stereotype.Component;

@Component("b")
//<bean id="b" class="..Student">
public class Student {
	public void show(){
		System.out.println("student");
	}
}
