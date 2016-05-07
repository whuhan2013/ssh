package cn.itcast.spring.jdbc.transaction.sh.service;

import java.util.List;

import org.springframework.transaction.PlatformTransactionManager;

import cn.itcast.spring.jdbc.transaction.bean.Person;
import cn.itcast.spring.jdbc.transaction.sh.dao.PersonDao;

public class PersonServiceImpl implements PersonService{
	private PersonDao personDao;

	public PersonDao getPersonDao() {
		return personDao;
	}

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	@Override
	public List<Person> getPerson() {
		// TODO Auto-generated method stub
		return this.personDao.getPerson();
	}

	@Override
	public void savePerson() {
		// TODO Auto-generated method stub
		this.personDao.savePerson();
		int a = 1/0;
	}
	
}
