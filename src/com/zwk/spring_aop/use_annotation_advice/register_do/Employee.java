package com.zwk.spring_aop.use_annotation_advice.register_do;

import java.math.BigDecimal;

public class Employee {
	private Integer id=null;
	private String name=null;
	private Integer age=null;
	private BigDecimal salary=null;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
