package com.zwk.spring_annotation.use_scope_postConstruct_perDestroy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * 作用域，初始化方法，释放资源方法注解
 * ①
 * 标注作用域 singleton单例时会执行销毁方法 prototype多例不会执行销毁方法 作用在类上
 * @Scope("singleton")
 * ②
 * 标注init方法
 * @PostConstruct
 * ③
 * 标注释放资源方法
 * @PreDestroy
 */
@SpringJUnitConfig
public class AnnotationTest {
	@Autowired
	AnnotationUseScopePostConstructPerDestroy myBean;

	@Test
	public void test() {
		myBean.doWork();
	}
}
