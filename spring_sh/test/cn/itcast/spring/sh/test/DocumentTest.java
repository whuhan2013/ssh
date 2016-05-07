package cn.itcast.spring.sh.test;

import org.junit.Test;

import cn.itcast.spring.sh.di.constructor.Person;
import cn.itcast.spring.sh.document.DocumentManager;
import cn.itcast.spring.sh.utils.SpringInit;

public class DocumentTest extends SpringInit{
	@Test
	public void test(){
		DocumentManager documentManager = (DocumentManager)context.getBean("documentManager");
		documentManager.read();
		documentManager.writer();
	}
}
