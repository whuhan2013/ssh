package cn.itcast.spring.sh.document;

public class ExcelDocument implements Document{
	public void read() {
		System.out.println("read excel");
	}
	public void writer() {
		System.out.println("writer excel");
	}
}
