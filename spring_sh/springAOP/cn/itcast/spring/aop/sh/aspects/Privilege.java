package cn.itcast.spring.aop.sh.aspects;

import org.aspectj.lang.ProceedingJoinPoint;

public class Privilege{
	private String access;

	public String getAccess() {
		return access;
	}

	public void setAccess(String access) {
		this.access = access;
	}
	
	public void isAccess(ProceedingJoinPoint joinPoint) throws Throwable{
		if(this.access.equals("admin")){
			joinPoint.proceed();
		}else{
			System.out.println("没有权限");
		}
	}
}
