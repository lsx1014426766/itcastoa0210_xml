package cn.itcast0210.oa.test;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author Administrator
 *
 */
public class SessionFactoryTest {
	/**
	 * 根据持久化类和映射文件生成表
	 */
	@Test
	public void testSessionFactory(){
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
	
		SessionFactory sessionFactory = (SessionFactory)context.getBean("sessionFactory");
	}
}
