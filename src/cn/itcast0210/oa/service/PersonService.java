package cn.itcast0210.oa.service;

import java.io.Serializable;

import cn.itcast0210.oa.domain.Person;

public interface PersonService {
	public void savePerson(Person person);
	
	public Person getPersonByID(Serializable id);
}
