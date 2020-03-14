package com.zwk.spring_annotation.use_autowired;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * 							在Spring测试中的@Autowired
 * 注意!!!以下两种方式中在spring测试中无需单独配置<context:annotation-config>
 * 如果不再spring测试中使用则需要单独配置<context:annotation-config>
 * ①
 * @Autowired 在spring测试中, 单独使用该注解时可以给set方法或者字段自动装载 装载顺序如下：
 * 1.根据类型装载
 * 2.有多个类型时尝试根据属性或set方法的名称进行自动装载
 * 3.当以上两条都无法装载时会报错,此时就使用第③种方法
 * ②
 * 当@Autowired(required=false)时表示如果没有改bean可以不进行装载,默认该参数为true
 * @Autowired(required = false)
 * ③
 * @Autowired
 * @Qualifier("userAction") 该字段必须与@Autowired字段一起使用
 * 在spring测试中装载时会根据@Qualifier("userAction")中的名称加载指定bean(不常用)
 */
@SpringJUnitConfig
public class AnnotationAutowiredTest {
	// 很明显该属性的名称为myName而且xml文件中有该id的bean,此时直接自动加载
	@Autowired
	private String myName;

	// 当@Autowired(required=false)时表示可以不加载但是xml中需要有该bean,默认该参数为true
	// 当使用该属性时该bean自动装载
	@Autowired(required = false)
	private String mySchoolName;

	// 很明显该属性的名称为mySuperName但是xml文件中并没有该id的bean,此时使用
	// @Autowired
	// @Qualifier("mySuperNames")
	@Autowired
	@Qualifier("mySuperNames")
	private String mySuperName;
	@Test
	public void test(){
		System.out.println(myName);
		System.out.println(mySuperName);
		System.out.println(mySchoolName);
	}
}
