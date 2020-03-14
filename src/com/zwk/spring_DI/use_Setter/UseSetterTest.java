package com.zwk.spring_DI.use_Setter;

import com.zwk.spring_DI.use_Setter.di_collection.CollectionBean;
import com.zwk.spring_DI.use_Setter.di_finl_value.Employee;
import com.zwk.spring_DI.use_Setter.di_object.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
public class UseSetterTest {
	@Autowired
	Employee employee;
	@Autowired
	Person person;
	@Autowired
	CollectionBean collectionBean;

	// 测试常量注入
	@Test
	public void Test() {
		System.out.println(employee);
	}

	// 测试对象注入
	@Test
	public void Test1() {
		System.out.println(person);
	}
	// 测试集合注入
	@Test
	public void Test2() {
		System.out.println(collectionBean);
	}
}
