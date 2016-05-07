package cn.itcast.spring.aop.annotation.sh;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;


/**
 * @Aspect
 * ==
 * <aop:config> 
 * 	 <aop:pointcut
 * 		expression=
 *     "execution(* cn.itcast.spring.aop.annotation.sh.PersonDaoImpl.*(..))"
 *     id="aa()"/>
 * </aop:config>
 * @author Think
 *
 */
@Component("myTransaction")
@Aspect
public class MyTransaction extends HibernateUtils{
	private Transaction transaction;
	
	@Pointcut("execution(* cn.itcast.spring.aop.annotation.sh.PersonDaoImpl.*(..))")
	private void aa(){}//方法签名  返回值必须是void  方法的修饰符最好是private
	
	@Before("aa()")
	public void beginTransaction(JoinPoint joinpoint){
		this.transaction = sessionFactory.getCurrentSession().beginTransaction();
	}
	
	@AfterReturning(value="aa()",returning="val")
	public void commit(Object val){
		this.transaction.commit();
	}
	
}
