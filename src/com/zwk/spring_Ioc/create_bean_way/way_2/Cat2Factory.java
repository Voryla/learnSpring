package com.zwk.spring_Ioc.create_bean_way.way_2;

public class Cat2Factory {
	// 静态工厂
	public static Cat2 getInstance(){
		Cat2 cat2=new Cat2();
		return cat2;
	}
}
