package cn.itcast.annotation.document;

import org.springframework.stereotype.Component;

@Component("pdfDocument")
public class PDFDocument implements Document{
	public void read() {
		System.out.println("read pdf");
	}
	public void writer() {
		System.out.println("writer pdf");
	}
	
}
