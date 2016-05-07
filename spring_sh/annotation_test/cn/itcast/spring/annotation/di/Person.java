package cn.itcast.spring.annotation.di;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Person {
	private Long pid;
	private String pname;
	
	@Resource(name="student")
//	@Autowired
//	@Qualifier("student")
	private Student student;
	
	private Set sets;
	
	private List lists;
	
	private Map map;
	
	private Properties properties;
	
	public void showStudent(){
		this.student.show();
	}
}
