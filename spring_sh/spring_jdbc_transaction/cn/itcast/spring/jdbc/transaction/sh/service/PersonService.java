package cn.itcast.spring.jdbc.transaction.sh.service;

import java.util.List;

import cn.itcast.spring.jdbc.transaction.bean.Person;

public interface PersonService {
	public void savePerson();
	public List<Person> getPerson();
}
