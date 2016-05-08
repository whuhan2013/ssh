package cn.itcast.s2sh.sh.dao;

import java.io.Serializable;

import cn.itcast.s2sh.domain.sh.Person;

public interface PersonDao {
	public void savePerson(Person person);
	
	public Person getPesonById(Serializable id);
}
