package cn.itcast.sh.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.itcast.sh.utils.HiberanteUtils;

public class EntityDao extends HiberanteUtils{
	/**
	 * 查找所有的数据
	 * @param <T>
	 * @param t
	 * @return
	 */
	public <T> List<T> find(Class<T> t) {
		Session session  = sessionFactory.openSession();
		List<T> list = session.createQuery("from "+t.getName()).list();
		session.close();
		return list;
	}
	
	public <T> T findByID(Class<T> t,Serializable id){
		Session session  = sessionFactory.openSession();
		T tt = (T)session.get(t, id);
		session.close();
		return tt;
	}
	
	public <T> void saveEntry(T t){
		Session session  = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(t);
		transaction.commit();
		session.close();
	}
	
	public <T> void updateEntry(T t){
		Session session  = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(t);
		transaction.commit();
		session.close();
	}
	
	public <T> void deleteEntry(Class<T> t,Serializable id){
		Session session  = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		T tt = this.findByID(t, id);
		session.delete(tt);
		transaction.commit();
		session.close();
	}
	
	public <T> T findUser(Class<T> t,String username,String password){
		Session session  = sessionFactory.openSession();
		Query query = session.createQuery("from User where username=:username and password=:password");
		query.setString("username", username);
		query.setString("password", password);
		T tt = (T)query.uniqueResult();
		session.close();
		return tt;
	}
}
