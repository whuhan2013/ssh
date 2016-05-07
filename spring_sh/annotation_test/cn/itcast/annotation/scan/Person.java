package cn.itcast.annotation.scan;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component("a")
//<bean id="a" class="..Person">
public class Person {
	
	@Resource(name="b")
	private Student student;

	public void showStudent(){
		this.student.show();
	}
}
