package cn.itcast.s2sh.struts2.action.sh;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast.s2sh.domain.sh.Person;
import cn.itcast.s2sh.sh.service.PersonService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.config.entities.ActionConfig;
import com.opensymphony.xwork2.config.impl.ActionConfigMatcher;

@Controller("personAction")
@Scope("prototype")
public class PersonAction extends ActionSupport{
	@Resource(name="personService")
	private PersonService personService;
	
	public String savePerson(){
		Person person = new Person();
		person.setPname("afds");
		this.personService.savePerson(person);
		return null;
	}
	
	public String showPerson(){
		System.out.println("annoation aaaaaaaaaaaaaaaaa");
		Person person = this.personService.getPersonByID(2L);
		ServletActionContext.getRequest().setAttribute("person", person);
		return "index";
	}
}
