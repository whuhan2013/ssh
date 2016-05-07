package cn.itcast.spring.jdbc.transaction.exception;

public class MyException {
	public void myException(Throwable ex){
		System.out.println(ex.getMessage());
	}
}
