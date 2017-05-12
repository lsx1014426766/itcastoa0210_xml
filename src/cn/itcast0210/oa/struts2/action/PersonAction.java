package cn.itcast0210.oa.struts2.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.itcast0210.oa.domain.Person;
import cn.itcast0210.oa.service.PersonService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

//@Controller(value="personAction")
//@Scope(value="prototype")
public class PersonAction extends ActionSupport{
	//@Resource(name="personService")
	private PersonService personService;
	

	public PersonService getPersonService() {
		return personService;
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

	public String savePerson(){
		Person person = new Person();
		person.setName("潘金莲");
		this.personService.savePerson(person);
		ServletActionContext.getRequest().setAttribute("person", person);
		return "index";
	}
	
	public String getPersonById(){
		Person person = this.personService.getPersonByID(1L);
		ServletActionContext.getRequest().setAttribute("person", person);
		return "index";
	}
}
