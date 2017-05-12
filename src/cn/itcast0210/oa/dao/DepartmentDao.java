package cn.itcast0210.oa.dao;

import java.io.Serializable;
import java.util.List;

import cn.itcast0210.oa.domain.Department;

/**
 * 对部门的增、删、改、查
 * @author Administrator
 *
 */
public interface DepartmentDao {
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
