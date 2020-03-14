package com.zwk.spring_annotation.use_resource;

import javax.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * 					在Spring测试中的@Resource 该注解是javaEE提供
 * 注意!!!以下两种方式中在spring测试中无需单独配置<context:annotation-config>
 * 如果不再spring测试中使用则需要单独配置<context:annotation-config>
 * ①
 * @Resource 在spring测试中, 单独使用该注解时可以给set方法或者字段自动装载 装载顺序如下：
 * 1.根据名称装载
 * 2.如果名称找不到时尝试根据类型进行自动装载
 * 3.当以上两条都无法装载时会报错,此时使用第②种方法
 * ②
 * @Resource(name="myName")
 * 在spring测试中装载时会根据@Resource(name="myName")中的名称加载指定bean
 */
@SpringJUnitConfig
public class AnnotationAutowiredUseResource {

	@Resource(name = "myName")
	private String myName;

	@Resource(name = "mySuperName")
	private String mySuperName;

	@Test
	public void test(){
		System.out.println(myName);
		System.out.println(mySuperName);
	}
}
