package com.zwk.springs;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class SourceTest {
	@Test
	public void test() {
		//-------------------------------
		// 1.根据classPath的路径寻找配置文件，创建资源对象
		Resource resource = new ClassPathResource("resource/applicationContext.xml");
		// 2.根据资源对象，创建Spring IoC容器对象
		BeanFactory beanFactory = new XmlBeanFactory(resource);
		// 3.从Spring IoC容器中获取指定名称的对象
		// 签名一根据xml文件中的配置的bean名称找到对象，不得出现同名
		Source source = (Source) beanFactory.getBean("source");

		// 签名二根据class的类型找到对象,但是当xml中存在两个该对象的bean时无法使用
		// Source source1=beanFactory.getBean(Source.class);

		// 签名三根据xml中bean名称+bean类型获得对象(推荐方式！)
		Source source2=beanFactory.getBean("source",Source.class);
		//--------------------------------
		System.out.println(source.getFruit());
		System.out.println(source.getSugar());
		System.out.println(source.getSize());
	}

	@Test
	public void testForSpringIoC() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[]{"resource/applicationContext.xml"}
		);
		Source source = (Source) context.getBean("source");
		//--------------------------------
		System.out.println(source.getFruit());
		System.out.println(source.getSugar());
		System.out.println(source.getSize());
	}

	/**
	 * spring IoC容器创建对象的原理
	 *
	 * @throws Exception
	 */
	@Test
	public void testMyBean() throws Exception {
		// 1.获取类的路径和名称
		String classPath = "com.com.zwk.springs.Source";
		// 2.创建空对象
		Source source = null;
		// 3.得到指定类的class文件
		Class clzz = Class.forName(classPath);
		// 3.获得该类的空构造函数
		Constructor constructor = clzz.getConstructor();
		// 4.防止构造函数的访问权限为private  将访问权限设为可访问
		constructor.setAccessible(true);
		// 5.创建对象
		Object obj = constructor.newInstance();
		// 6.使用java的类型机制设置属性值
		// 第二个属性代表排除指定class文件中的某个类的class
		BeanInfo beanInfo = Introspector.getBeanInfo(clzz, Object.class);
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
			String propertyName = propertyDescriptor.getName();
			if ("fruit".equals(propertyName)) {
				propertyDescriptor.getWriteMethod().invoke(obj, "西瓜");
			} else if ("sugar".equals(propertyName)) {
				propertyDescriptor.getWriteMethod().invoke(obj, "多糖");
			} else if ("size".equals(propertyName)) {
				propertyDescriptor.getWriteMethod().invoke(obj, "大杯");
			}
		}
		source = (Source) obj;
		System.out.println(source.getFruit());
		System.out.println(source.getSugar());
		System.out.println(source.getSize());
	}
}
