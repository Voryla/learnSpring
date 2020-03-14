package com.zwk.spring_annotation.use_value;

import org.springframework.beans.factory.annotation.Value;

public class ValueBean {
	@Value("9999")
	private Integer age;
	@Value("${service.port}")
	private Integer salary;

	@Override
	public String toString() {
		return "ValueBean{" +
				"age=" + age +
				", salary=" + salary +
				'}';
	}
}
