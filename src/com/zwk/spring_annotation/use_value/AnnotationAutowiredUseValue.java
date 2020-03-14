package com.zwk.spring_annotation.use_value;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
public class AnnotationAutowiredUseValue {
	@Autowired
	private ValueBean valueBean;
	@Test
	public void test(){
		System.out.println(valueBean);
	}
}
