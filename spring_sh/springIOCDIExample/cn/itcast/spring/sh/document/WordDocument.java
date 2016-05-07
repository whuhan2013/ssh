package cn.itcast.spring.sh.document;

public class WordDocument implements Document{
	public void read() {
		System.out.println("read word");
	}
	public void writer() {
		System.out.println("writer word");
	}
}
