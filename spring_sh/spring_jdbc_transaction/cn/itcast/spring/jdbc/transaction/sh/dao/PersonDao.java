package cn.itcast.spring.jdbc.transaction.sh.dao;

import java.util.List;

import cn.itcast.spring.jdbc.transaction.bean.Person;

public interface PersonDao {
	public void savePerson();
	public List<Person> getPerson();
}
