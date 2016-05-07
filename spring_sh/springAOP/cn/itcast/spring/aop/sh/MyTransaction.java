package cn.itcast.spring.aop.sh;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.hibernate.Transaction;

import cn.itcast.spring.aop.annotation.sh.HibernateUtils;

public class MyTransaction extends HibernateUtils{
	private Transaction transaction;
	/**
	 * 通过该参数可以获取目标方法的一些信息
	 * @param joinpoint
	 */
	public void beginTransaction(JoinPoint joinpoint){
		System.out.println("bbb");
		this.transaction = sessionFactory.getCurrentSession().beginTransaction();
	}
	
	public void commit(Object var){
		System.out.println(var);
		this.transaction.commit();
	}
	
	public void finallyMethod(){
		System.out.println("finally method");
	}
	
	/**
	 * 异常通知
	 * @param ex
	 */
	public void throwingMethod(Throwable ex){
		System.out.println(ex.getMessage());
	}
	
	public void aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println(joinPoint.getSignature().getName());
		joinPoint.proceed();//调用目标方法
		System.out.println("aaaasfdasfd");
	}
}
