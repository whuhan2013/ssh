package cn.itcast.spring.sh.document;

import org.junit.Test;

public class DocumentTest {
	@Test
	public void test(){
		Document wordDocument = new WordDocument();
		DocumentManager documentManager = new DocumentManager(wordDocument);
		documentManager.read();
		documentManager.writer();
	}
}
