package cn.itcast.annotation.document;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component("documentManager")
public class DocumentManager {
	
	@Resource(name="wordDocument")
	private Document document;
	
	public void read(){
		this.document.read();
	}
	public void writer(){
		this.document.writer();
	}
}
