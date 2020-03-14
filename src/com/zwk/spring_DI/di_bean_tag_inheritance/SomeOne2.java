package com.zwk.spring_DI.di_bean_tag_inheritance;
public class SomeOne2 {
	private String name=null;
	private int width=0;
	public void setName(String name) {
		this.name = name;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public String toString() {
		return "SomeOne2{" +
				"name='" + name + '\'' +
				", width=" + width +
				'}';
	}
}
