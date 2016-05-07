package cn.itcast.spring.mvc.exception.service.impl;

import cn.itcast.spring.mvc.exception.dao.PersonDao;
import cn.itcast.spring.mvc.exception.service.PersonService;
import cn.itcast.spring.mvc.myexception.Exception2;

public class PersonServiceImpl implements PersonService{
	
	private PersonDao personDao;

	public PersonDao getPersonDao() {
		return personDao;
	}

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	@Override
	public void savePerson() throws Exception{
		// TODO Auto-generated method stub
		this.personDao.savePerson();
		throw new Exception2("afdasdf");
	}

}
