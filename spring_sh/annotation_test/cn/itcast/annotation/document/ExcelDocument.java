package cn.itcast.annotation.document;

import org.springframework.stereotype.Component;

@Component("excelDocument")
public class ExcelDocument implements Document{
	public void read() {
		System.out.println("read excel");
	}
	public void writer() {
		System.out.println("writer excel");
	}
}
