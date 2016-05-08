package cn.itcast.s2sh.sh.dao.impl;

import java.io.Serializable;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.itcast.s2sh.domain.sh.Person;
import cn.itcast.s2sh.sh.dao.PersonDao;

public class PersonDaoImpl extends HibernateDaoSupport implements PersonDao{

	@Override
	public void savePerson(Person person) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(person);
	}

	@Override
	public Person getPesonById(Serializable id) {
		// TODO Auto-generated method stub
		return (Person) this.getHibernateTemplate().load(Person.class, id);
	}
	
}
