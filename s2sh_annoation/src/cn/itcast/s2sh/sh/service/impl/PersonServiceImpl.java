package cn.itcast.s2sh.sh.service.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.s2sh.domain.sh.Person;
import cn.itcast.s2sh.sh.dao.PersonDao;
import cn.itcast.s2sh.sh.service.PersonService;

@Service("personService")
public class PersonServiceImpl implements PersonService{
	@Resource(name="personDao")
	private PersonDao personDao;

	@Override
	@Transactional(readOnly=false)
	public void savePerson(Person person) {
		// TODO Auto-generated method stub
		this.personDao.savePerson(person);
	}

	@Override
	public Person getPersonByID(Serializable id) {
		// TODO Auto-generated method stub
		Person person = this.personDao.getPesonById(id);
		return person;
	}
}
