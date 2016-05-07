package cn.itcast.jdkproxy.hibernate.sh;

import java.io.Serializable;

public interface PersonDao {
	public String savePerson(Person person);
	
	public void updatePerson(Person person);
	
	public void deletePerson(Serializable id);
}
