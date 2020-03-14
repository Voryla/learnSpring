package com.zwk.spring_dao.jdbc_do;

import java.math.BigDecimal;

public class MyEmployee {
	private Integer id;
	private String name;
	private BigDecimal salary;
	private Integer age;

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public Integer getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "MyEmployee{" +
				"id=" + id +
				", name='" + name + '\'' +
				", salary=" + salary +
				", age=" + age +
				'}';
	}
}
