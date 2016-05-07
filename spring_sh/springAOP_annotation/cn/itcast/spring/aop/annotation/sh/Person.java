package cn.itcast.spring.aop.annotation.sh;

import java.io.Serializable;


/**
 * 对象的序列化的作用：让对象在网络上传输,以二进制的形式传输
 * @author Think
 * Serializable标示接口
 */
public class Person implements Serializable{
	private Long pid;
	private String pname;
	
	public Person(){}
	
	public Person(String pname){
		this.pname = pname;
	}
	
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPsex() {
		return psex;
	}
	public void setPsex(String psex) {
		this.psex = psex;
	}
	private String psex;
}
