package com.zwk.spring_Ioc.create_bean_way.way_4;

import org.springframework.beans.factory.FactoryBean;

/**
 * 示例工厂实现FactoryBean接口
 */
public class Cat4Factory implements FactoryBean<Cat4> {
	@Override
	public Cat4 getObject() throws Exception {
		Cat4 cat4=new Cat4();
		return cat4;
	}

	@Override
	public Class<?> getObjectType() {
		return Cat4.class;
	}
}
