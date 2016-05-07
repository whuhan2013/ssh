package cn.itcast.annotation.mvc;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("personService")
public class PersonServiceImpl implements PersonService{

	@Resource(name="personDao")
	private PersonDao personDao;
	
	@Override
	public void savePerson() {
		// TODO Auto-generated method stub
		this.personDao.savePerson();
	}

}
