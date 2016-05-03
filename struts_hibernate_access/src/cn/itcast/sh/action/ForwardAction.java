package cn.itcast.sh.action;

import com.opensymphony.xwork2.ActionSupport;

public class ForwardAction extends ActionSupport{
	private String method;
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String execute(){
		return this.method;
	}
}
