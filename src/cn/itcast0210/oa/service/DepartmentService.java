package cn.itcast0210.oa.service;

import java.io.Serializable;
import java.util.List;

import cn.itcast0210.oa.dao.DepartmentDao;
import cn.itcast0210.oa.domain.Department;

public interface DepartmentService{
	/**
	 * 增加
	 */
	public void saveDepartment(Department department);
	
	/**
	 * 修改
	 */
	
	public void updateDepartment(Department department);
	
	/*
	 * 根据ID进行查询
	 */
	public Department getDepartmentByID(Serializable id);
	
	/**
	 * 删除
	 */
	public void deleteDepartmentByID(Serializable id);
	
	/*
	 * 查询所有的数据
	 */
	public List<Department> getAllDepartment();
}
