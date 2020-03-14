package com.zwk.spring_DI.di_constructor;

import java.math.BigDecimal;
import java.util.List;

public class Employees {
	private String name=null;
	private Integer age=0;
	private BigDecimal salary=null;
	private List<Integer> list;

	public Employees(String name, Integer age, BigDecimal salary,List<Integer> list) {
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.list=list;
	}

	@Override
	public String toString() {
		return "Employees{" +
				"name='" + name + '\'' +
				", age=" + age +
				", salary=" + salary +
				", list=" + list +
				'}';
	}
}
