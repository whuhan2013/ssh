package cn.itcast.spring.jdbc;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DataSourceTest {
	@Test
	public void test(){
		ApplicationContext context = new ClassPathXmlApplicationContext("cn/itcast/spring/jdbc/applicationContext.xml");
		DataSource dataSource = (DataSource)context.getBean("dataSource");
	}
}
