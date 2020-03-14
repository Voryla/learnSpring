package com.zwk.spring_Ioc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

//@SpringJUnitConfig
//@ContextConfiguration("classpath:com/zwk/spring_Ioc/personContext.xml")

/**
 * 1.BeanFactory 有延迟初始化对象的特点(懒:lazy)，在创建Spring容器的时候，不会立即创建容器中管理的Bean对象，
 * 而是等到从容器中获取对象的时候，才创建对象。
 * 2.ApplicationContext在创建Spring容器的时候，就会立刻创建容器中所管理的Bean对象，
 * 而不是等到获取Bean对象的时候再创建
 * 两种方式的不同主要是因为XmlBeanFactory(resource)类和ClassPathXmlApplicationContext("")的不同
 * BeanFactory也可以使用下面的方式创建
 * BeanFactory beanFactory=new ClassPathXmlApplicationContext("resource/applicationContext.xml");
 * 3.
 * (1)自动按照类型去Spring容器中找到bean对象，并设置给该字段
 *    @Autowired
 *    private SomeBean bean;
 * (2)也可以自动注解BeanFactory对象
 *    @Autowired
 *    private BeanFactory beanFactory;
 * (3)也可以自动注解BeanFactory对象
 *    @Autowired
 *    private ApplicationContext ctx;
 */
public class PersonTest {

	@Test
	public void tests(){
		Resource resource=new ClassPathResource("resource/applicationContext.xml");
		BeanFactory beanFactory=new XmlBeanFactory(resource);
		// BeanFactory beanFactory=new ClassPathXmlApplicationContext("resource/applicationContext.xml");
		System.out.println("-----------------------------------------");
		Person person=beanFactory.getBean("person",Person.class);
		System.out.println(person.getName());
	}

	@Test
	public void tests_1(){
		ApplicationContext ctx=
				new ClassPathXmlApplicationContext("resource/applicationContext.xml");
		System.out.println("-----------------------------------------");
		Person person=ctx.getBean("person",Person.class);
		System.out.println(person.getName());

	}
}
