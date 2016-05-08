package cn.itcast.s2sh.sh.service.impl;

import java.io.Serializable;

import cn.itcast.s2sh.domain.sh.Person;
import cn.itcast.s2sh.sh.dao.PersonDao;
import cn.itcast.s2sh.sh.service.PersonService;

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

	@Override
	public Person getPersonByID(Serializable id) {
		// TODO Auto-generated method stub
		return this.personDao.getPesonById(id);
	}
}
