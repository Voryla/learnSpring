package com.zwk.spring_DI.di_bean_tag_inheritance;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * 本包演示 spring中属性抽离
 */
@SpringJUnitConfig
public class BeanTagTest {
	@Autowired
	private SomeOne1 someOne1;
	@Autowired
	private SomeOne2 someOne2;
	@Test
	public void test(){
		System.out.println(someOne1);
		System.out.println(someOne2);
	}
}
