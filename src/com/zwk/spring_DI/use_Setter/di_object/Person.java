package com.zwk.spring_DI.use_Setter.di_object;

/**
 * 对象注入
 */
public class Person {
	private Cat cat;

	public void setCat(Cat cat) {
		this.cat = cat;
	}

	@Override
	public String toString() {
		return "Person{" +
				"cat=" + cat +
				'}';
	}
}
