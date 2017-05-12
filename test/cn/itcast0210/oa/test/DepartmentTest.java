package cn.itcast0210.oa.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast0210.oa.dao.DepartmentDao;
import cn.itcast0210.oa.domain.Department;
import cn.itcast0210.oa.service.DepartmentService;

/**
 * 对部门的测试
 * 加载spring xml配置文件
 * 
 * @author Administrator
 * 
 */
public class DepartmentTest {
	@Test
	public void testSaveDepartment() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring/applicationContext.xml");

		DepartmentService departmentService = (DepartmentService) context
				.getBean("departmentService");

		Department department = new Department();
		department.setDname("美女部");
		department.setDescription("很多美女");

		departmentService.saveDepartment(department);
	}

	@Test
	public void testQueryDepartment() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring/applicationContext.xml");

		DepartmentService departmentService = (DepartmentService) context
				.getBean("departmentService");

		List<Department> departmentList = departmentService.getAllDepartment();

		System.out.println(departmentList.size());
	}

	@Test
	public void testSaveDepartment2() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring/applicationContext.xml");

		DepartmentDao departmentDao = (DepartmentDao) context
				.getBean("departmentDao");

		Department department = new Department();
		department.setDname("美女部");
		department.setDescription("很多美女");

		departmentDao.saveDepartment(department);
	}

	@Test
	public void testDepartment() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring/applicationContext.xml");

		SessionFactory sessionFactory = (SessionFactory) context
				.getBean("sessionFactory");

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		Department department = new Department();
		department.setDname("美女部");
		department.setDescription("很多美女");
		/**
		 * 这个对象将变成持久化状态的对象，并且这个对象将进入到session的一级缓存中
		 */
		session.save(department);
//org.hibernate.NonUniqueObjectException: a different object with the same identifier value was already associated with the session: [cn.itcast0210.oa.domain.Department#3]

		/*Department department1 = new Department();

		department1.setDid(department.getDid());

		department1.setDname("aaaa");
*/
		/**
		 * Hibernate: select max(did) from department
Hibernate: insert into department (dname, description, did) values (?, ?, ?)
Hibernate: update department set dname=?, description=? where did=?
		 */
		department.setDname("lll");
		session.update(department);

		transaction.commit();
		session.close();
	}

	@Test
	public void testUpdate() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring/applicationContext.xml");

		DepartmentService departmentService = (DepartmentService) context
				.getBean("departmentService");

		Department department = departmentService.getDepartmentByID(1L);

		department.setDescription("模特很多");

		departmentService.updateDepartment(department);
	}

	@Test
	public void testDelete() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring/applicationContext.xml");

		DepartmentService departmentService = (DepartmentService) context
				.getBean("departmentService");

		departmentService.deleteDepartmentByID(1L);
	}
}
