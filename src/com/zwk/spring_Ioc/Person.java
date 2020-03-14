package com.zwk.spring_Ioc;

public class Person {
	private String name=null;
	private Integer age=0;
	public Person(){
		System.out.println("构建Person对象");
	}
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
}
