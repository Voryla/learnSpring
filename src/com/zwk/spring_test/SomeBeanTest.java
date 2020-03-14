package com.zwk.spring_test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * Spring的测试框架
 * 运行Spring的JUnit4
 * RunWith(SpringJUnit4ClassRunner.class)
 * @ContextConfiguration("classpath:resource/applicationContext.xml")
 *
 * 运行Spring的JUnit5测试
 * @SpringJUnitConfig
 * @ContextConfiguration("classpath:resource/applicationContext.xml")
 *
 * 无论是JUnit4或者JUnit5@ContextConfiguration()可以不带参数或者直接不写这个注解来获取xml文件
 * 当使用默认的时候就要将该测试类包中的xml文件改为 本测试类的名称-context.xml
 * 例： 在本项目中就是  SomeBeamTest-context.xml
 */
// 运行Spring的JUnit5测试
@SpringJUnitConfig
@ContextConfiguration("classpath:resource/applicationContext.xml")
public class SomeBeanTest {
	// 自动按照类型去Spring容器中找到bean对象，并设置给该字段
	@Autowired
	private SomeBean bean;
	// 也可以自动注解BeanFactory对象
	@Autowired
	private BeanFactory beanFactory;
	// 也可以自动注解BeanFactory对象
	@Autowired
	private ApplicationContext ctx;
	@Test
	public void test() {
		bean.doWork();
	}
}
