package cn.itcast.spring.hibernate.transaction.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.itcast.spring.hiberante.transaction.domain.Person;
import cn.itcast.spring.hibernate.transaction.dao.PersonDao;

public class PersonDaoImpl extends HibernateDaoSupport implements PersonDao{

	@Override
	public void savePerson(Person person) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(person);
	}
	
}
