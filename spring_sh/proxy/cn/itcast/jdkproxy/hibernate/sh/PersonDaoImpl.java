package cn.itcast.jdkproxy.hibernate.sh;

import java.io.Serializable;

public class PersonDaoImpl extends HibernateUtils implements PersonDao{

	@Override
	public void deletePerson(Serializable id) {
		// TODO Auto-generated method stub
		Person person = (Person)sessionFactory.getCurrentSession().get(Person.class, 1L);
		sessionFactory.getCurrentSession().delete(person);
	}

	@Override
	public String savePerson(Person person) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(person);
		return "afdadsf";
	}

	@Override
	public void updatePerson(Person person) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(person);
	}

}
