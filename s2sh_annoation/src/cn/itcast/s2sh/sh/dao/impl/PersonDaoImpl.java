package cn.itcast.s2sh.sh.dao.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.itcast.s2sh.domain.sh.Person;
import cn.itcast.s2sh.sh.dao.PersonDao;

@Repository("personDao")
public class PersonDaoImpl implements PersonDao{
	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	@Override
	public void savePerson(Person person) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.save(person);
	}

	@Override
	public Person getPesonById(Serializable id) {
		// TODO Auto-generated method stub
		return  (Person) this.hibernateTemplate.load(Person.class, id);
	}
	
}
