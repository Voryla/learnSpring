package com.zwk.spring_annotation.use_component;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 使用组件加载bean
 * 以下4个组件功能相同都是不适用xml添加bean。   一定要注意!!!!要在在xml中添加IOC解析器!! <context:component-scan base-package="包名"/>
 * @Component 泛指组件 当组件不好分类时,我们可以使用这个注解进行标注
 * @Service 用于标注业务层组件
 * @Repository 用于标注数据访问组件
 * @Controller 用于标注控制层组件(如struts中的Action,SpringMVC的Controller)
 */

public class AnnotationAutowiredUseComponent {
	@Test
	public void test() {
		ApplicationContext applicationContext =
				new ClassPathXmlApplicationContext("com/zwk/spring_annotation/use_component/AnnotationAutowiredUseComponent.xml");
		Cat cat = applicationContext.getBean("myCat", Cat.class);
		System.out.println(cat);
	}
}
