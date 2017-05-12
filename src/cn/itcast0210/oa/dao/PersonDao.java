package cn.itcast0210.oa.dao;

import java.io.Serializable;

import cn.itcast0210.oa.domain.Person;

public interface PersonDao {
	public void savePerson(Person person);
	
	public Person getPersonById(Serializable id);
}
