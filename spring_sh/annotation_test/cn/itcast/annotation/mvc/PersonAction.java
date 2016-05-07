package cn.itcast.annotation.mvc;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

@Controller("personAction")
public class PersonAction {
	@Resource(name="personService")
	private PersonService personService;
	
	public void savePerson(){
		this.personService.savePerson();
	}
}
