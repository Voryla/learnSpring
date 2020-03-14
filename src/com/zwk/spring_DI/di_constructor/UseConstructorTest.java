package com.zwk.spring_DI.di_constructor;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
public class UseConstructorTest {
	@Autowired
	Employees employees;
	@Test
	public void test(){
		System.out.println(employees);
	}
}
