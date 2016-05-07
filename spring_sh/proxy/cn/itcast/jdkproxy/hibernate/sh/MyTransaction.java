package cn.itcast.jdkproxy.hibernate.sh;

import org.hibernate.Transaction;

public class MyTransaction extends HibernateUtils{
	private Transaction transaction;
	public void beginTransaction(){
		this.transaction = sessionFactory.getCurrentSession().beginTransaction();
	}
	
	public void commit(){
		this.transaction.commit();
	}
}
