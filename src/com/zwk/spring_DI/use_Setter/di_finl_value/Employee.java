package com.zwk.spring_DI.use_Setter.di_finl_value;

import java.math.BigDecimal;

/**
 * 属性注入：常量类型 并不是真正的final关键字修饰的常量，而是可以作为对象创建即可初始化属性的一些值
 */
public class Employee {

	private String name = null;
	private Integer age = null;
	private BigDecimal salary = null;

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"name='" + name + '\'' +
				", age=" + age +
				", salary=" + salary +
				'}';
	}
}
