package com.easyway.json.android;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 在android中有时候我们不需要用到本机的SQLite数据库提供数据，更多的时候是从网络上获取数据，
 * 那么Android怎么从服务器端获取数据呢？有很多种，归纳起来有
 *一：基于Http协议获取数据方法。
 *二：基于SAOP协议获取数据方法，
 *那么我们的这篇文章主要是将关于使用Http协议获取服务器端数据，
 *这里我们采取的服务器端技术为java，框架为Struts2,或者可以有Servlet,又或者可直接从JSP页面中获取数据。
 *那么，接下来我们便开始这一路程：
 *首先：编写服务器端方法,我这里采用的MVC框架是Struts2，目的很单纯，就是为了以后做个完整的商业项目，
 *技术配备为：android+SSH。当然，篇幅有限，我这里就直接用Strtus2而已。
 *服务器端：新建WebProject ,选择Java ee 5.0.
 *为了给项目添加Struts2的支持，我们必须导入Struts2的一些类库，如下即可（有些jar包是不必的，但是我们后来扩展可能是要使用到的，就先弄进去）：
 *xwork-core-2.2.1.1.jar  struts2-core-2.2.1.1.jar commons-logging-1.0.4.jar  freemarker-2.3.16.jar
 *ognl-3.0.jar  javassist-3.7.ga.jar commons-ileupload.jar commons-io.jar json-lib-2.1-jdk15.jar  
 *处理JSON格式数据要使用到 struts2-json-plugin-2.2.1.1.jar   
 * 基于struts2的json插件.
 * 
 * 
 * 采用接口注入的方式注入HttpServletRequest,HttpServletResponse对象
 * 
 * @author longgangbai
 *
 */
public class LoginAction extends ActionSupport implements ServletRequestAware,
		ServletResponseAware {
	/** * */
	private static final long serialVersionUID = 1L;

	HttpServletRequest request;

	HttpServletResponse response;
	
	private String userName;
	private String password;
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
    
	/**
	 * 模拟用户登录的业务
	 */
	public void login() {
		try {
              //如果不采用接口注入的方式的获取HttpServletRequest，HttpServletResponse的方式
			  // HttpServletRequest request =ServletActionContext.getRequest();
			  // HttpServletResponse response=ServletActionContext.getResponse();
			
			   this.response.setContentType("text/json;charset=utf-8");
			   this.response.setCharacterEncoding("UTF-8");
			   //JSONObject json=new JSONObject(); 
			    Map<String,String> json=new HashMap<String,String>();
				if ("admin".equals(userName)&&"123456".equals(password)) {
					 json.put("message", "欢迎管理员登陆");
				} else if ((!"admin".equals(userName))&&"123456".equals(password)) {
					json.put("message", "欢迎"+userName+"登陆！");
				} else {
					json.put("message", "非法登陆信息！");
				}
			  byte[] jsonBytes = json.toString().getBytes("utf-8");
			  response.setContentLength(jsonBytes.length);
			  response.getOutputStream().write(jsonBytes);
			  response.getOutputStream().flush();
			  response.getOutputStream().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}