package cn.itcast.s2sh.sh.service;

import java.io.Serializable;

import cn.itcast.s2sh.domain.sh.Person;

public interface PersonService {
	public void savePerson(Person person);
	
	public Person getPersonByID(Serializable id);
}
