package com.zwk.spring_DI.autowired;

import java.util.Date;

// 要提供set方法否则xml无法自动装配
public class Person {
	private Dog dog;


	public Person(Dog dog){
		this.dog=dog;
	}
	public Person(Dog dog, Date date){
		this.dog=dog;
	}
	public Person(){}
	public void print() {
		System.out.println("dog"+dog);
	}
}
