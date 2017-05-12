package cn.itcast0210.oa.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.orm.jdo.JdoTransactionManager;
import org.springframework.orm.toplink.TopLinkTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.AbstractPlatformTransactionManager;

import cn.itcast0210.oa.dao.PersonDao;
import cn.itcast0210.oa.domain.Person;
/**
 * @Repository(value="personDao")
 * = 
 * <bean id="personDao" class="..PersonDaoImpl"/>
 * 
 * @Repository
 * =
 * <bean id="personDaoImpl" class="..PersonDaoImpl"/>
 */
@Repository(value="personDao")
public class PersonDaoImpl extends HibernateDaoSupport implements PersonDao{
	

	public void savePerson(Person person) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(person);
	}

	@Override
	public Person getPersonById(Serializable id) {
		// TODO Auto-generated method stub
		//select person0_.id as id0_0_, person0_.name as name0_0_ from person person0_ where person0_.id=?
		Object p = this.getHibernateTemplate().load(Person.class, id);
		
		return (Person)p;
		
	}

}
