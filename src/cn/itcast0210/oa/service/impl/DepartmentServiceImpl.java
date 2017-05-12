package cn.itcast0210.oa.service.impl;

import java.io.Serializable;
import java.util.List;

import cn.itcast0210.oa.dao.DepartmentDao;
import cn.itcast0210.oa.domain.Department;
import cn.itcast0210.oa.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService{
	private DepartmentDao departmentDao;

	public DepartmentDao getDepartmentDao() {
		return departmentDao;
	}

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	@Override
	public void deleteDepartmentByID(Serializable id) {
		// TODO Auto-generated method stub
		this.departmentDao.deleteDepartmentByID(id);
	}

	@Override
	public List<Department> getAllDepartment() {
		// TODO Auto-generated method stub
		return this.departmentDao.getAllDepartment();
	}

	@Override
	public Department getDepartmentByID(Serializable id) {
		// TODO Auto-generated method stub
		return this.departmentDao.getDepartmentByID(id);
	}

	@Override
	public void saveDepartment(Department department) {
		// TODO Auto-generated method stub
		this.departmentDao.saveDepartment(department);
	}

	@Override
	public void updateDepartment(Department department) {
		// TODO Auto-generated method stub
		this.departmentDao.updateDepartment(department);
	}
}
