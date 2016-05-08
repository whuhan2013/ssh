package cn.itcast.s2sh.sh.test;

import org.junit.Test;

import cn.itcast.s2sh.sh.utils.SpringInit;

public class SessionFactoryTest extends SpringInit{
	@Test
	public void testSessionFactory(){
		context.getBean("sessionFactory");
	}
}
