package cn.itcast.spring.sh.document;

public class DocumentManager {
	private Document document;
	public DocumentManager(Document document){
		this.document = document;
	}	
	public void read(){
		this.document.read();
	}
	public void writer(){
		this.document.writer();
	}
}
