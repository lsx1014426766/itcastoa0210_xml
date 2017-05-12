package cn.itcast0210.oa.dao.impl;

import java.io.Serializable;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.itcast0210.oa.dao.PersonDao;
import cn.itcast0210.oa.domain.Person;

public class PersonDao2Impl implements PersonDao{
	private HibernateTemplate hibernateTemplate;

	public void savePerson(Person person) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.save(person);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public Person getPersonById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}
}
