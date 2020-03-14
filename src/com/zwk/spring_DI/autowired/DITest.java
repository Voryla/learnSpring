package com.zwk.spring_DI.autowired;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
@SpringJUnitConfig
public class DITest {
	@Autowired
	Person person;
	@Test
	public void test(){
		person.print();
	}
}
