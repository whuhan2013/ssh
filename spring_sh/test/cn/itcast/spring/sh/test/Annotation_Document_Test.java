package cn.itcast.spring.sh.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.annotation.document.DocumentManager;


public class Annotation_Document_Test{
	@Test
	public void testPerson(){
		ApplicationContext context = new ClassPathXmlApplicationContext("cn/itcast/annotation/document/applicationContext-document.xml");
		DocumentManager documentManager = (DocumentManager)context.getBean("documentManager");
		documentManager.read();
		documentManager.writer();
	}
}
