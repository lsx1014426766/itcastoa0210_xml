package cn.itcast0210.oa.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.itcast0210.oa.dao.DepartmentDao;
import cn.itcast0210.oa.domain.Department;

public class DepartmentDaoImpl  implements DepartmentDao{

	private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void deleteDepartmentByID(Serializable id) {
		// TODO Auto-generated method stub
		Department department = (Department)this.getHibernateTemplate().get(Department.class, id);
		this.getHibernateTemplate().delete(department);
	}

	@Override
	public List<Department> getAllDepartment() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from Department");
	}

	@Override
	public Department getDepartmentByID(Serializable id) {
		// TODO Auto-generated method stub
		return (Department) this.getHibernateTemplate().get(Department.class, id);
	}

	@Override
	public void saveDepartment(Department department) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(department);
	}

	@Override
	public void updateDepartment(Department department) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(department);
	}

}
