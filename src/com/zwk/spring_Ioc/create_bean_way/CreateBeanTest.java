package com.zwk.spring_Ioc.create_bean_way;

import com.zwk.spring_Ioc.bean_init_and_destroy.MyDatabase;
import com.zwk.spring_Ioc.create_bean_way.bean_scope.BeanScope;
import com.zwk.spring_Ioc.create_bean_way.way_1.Cat1;
import com.zwk.spring_Ioc.create_bean_way.way_2.Cat2;
import com.zwk.spring_Ioc.create_bean_way.way_2.Cat2Factory;
import com.zwk.spring_Ioc.create_bean_way.way_3.Cat3;
import com.zwk.spring_Ioc.create_bean_way.way_3.Cat3Factory;
import com.zwk.spring_Ioc.create_bean_way.way_4.Cat4;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
//@ContextConfiguration("classpath:resource/applicationContext.xml")
public class CreateBeanTest {
	@Autowired
	BeanScope beanScope1;
	@Autowired
	BeanScope beanScope2;
	@Autowired
	BeanScope beanScope3;
	@Autowired
	MyDatabase myDatabase;
	@Autowired
	MyDatabase myDatabase1;
	@Autowired
	Cat1 c1;
	@Autowired
	Cat2 c2;
	@Autowired
	Cat3 c3;
	@Autowired
	Cat4 c4;

	@Test
	public void beanScopeTest() {
		// 根据更改xml文件中BeanScope的bean中的scope参数可以控制Spring获取对象时
		// 是使用单例还是多例
		System.out.println(beanScope1);
		System.out.println(beanScope2);
		System.out.println(beanScope3);
	}

	@Test
	public void myDatabaseTest(){
		myDatabase.doWork();
		myDatabase1.doWork();
	}
	@Test
	public void test1() {
		// 方式一使用构造器创建
		Cat1 cat1 = new Cat1();
		Cat2 cat2 = Cat2Factory.getInstance();
		Cat3 cat3 = new Cat3Factory().getInstance();
	}

	@Test
	public void test2() {
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
	}
}
