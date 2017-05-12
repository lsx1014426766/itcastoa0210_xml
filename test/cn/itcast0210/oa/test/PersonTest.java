package cn.itcast0210.oa.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast0210.oa.domain.Person;
import cn.itcast0210.oa.service.PersonService;

public class PersonTest {
	@Test
	public void test(){
		/**
		 * 1、启动spring容器，加载spring的配置文件
		 * 2、找到personService
		 * 3、执行personService的savePerson方法
		 */
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
	
		PersonService personService = (PersonService)context.getBean("personService");
		
		Person person = new Person();
		person.setName("王二麻子");
		
		personService.savePerson(person);
	}
}
