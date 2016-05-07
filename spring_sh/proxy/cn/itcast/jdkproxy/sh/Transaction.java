package cn.itcast.jdkproxy.sh;

public class Transaction {
	public void beginTransaction(){
		System.out.println("开启事务 ");
	}
	public void commit(){
		System.out.println("事务提交");
	}
}
