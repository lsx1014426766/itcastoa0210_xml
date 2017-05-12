package cn.itcast0210.oa.service.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.itcast0210.oa.dao.PersonDao;
import cn.itcast0210.oa.domain.Person;
import cn.itcast0210.oa.service.PersonService;

//@Service(value="personService")
public class PersonServiceImpl implements PersonService{
	
	private PersonDao personDao;

	public PersonDao getPersonDao() {
		return personDao;
	}

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

	public void savePerson(Person person) {
		// TODO Auto-generated method stub
		this.personDao.savePerson(person);
	}

	@Override
	public Person getPersonByID(Serializable id) {
		// TODO Auto-generated method stub
		Person person = this.personDao.getPersonById(id);
		return person;
	}
}
