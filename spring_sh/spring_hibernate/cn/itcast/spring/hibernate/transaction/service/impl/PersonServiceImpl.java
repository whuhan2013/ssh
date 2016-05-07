package cn.itcast.spring.hibernate.transaction.service.impl;

import org.hibernate.impl.SessionFactoryImpl;
import org.springframework.orm.jdo.JdoTemplate;
import org.springframework.orm.toplink.TopLinkTemplate;

import cn.itcast.spring.hiberante.transaction.domain.Person;
import cn.itcast.spring.hibernate.transaction.dao.PersonDao;
import cn.itcast.spring.hibernate.transaction.service.PersonService;

public class PersonServiceImpl implements PersonService{
	private PersonDao personDao;

	public PersonDao getPersonDao() {
		return personDao;
	}

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	@Override
	public void savePerson(Person person) {
		// TODO Auto-generated method stub
		this.personDao.savePerson(person);
	}
}
