package com.zwk.spring_annotation.use_scope_postConstruct_perDestroy;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
// 标注组件加载bean,id为myBean
@Component("myBean")
// 标注作用域 singleton单例时会执行销毁方法 prototype多例不会执行销毁方法
@Scope("singleton")
public class AnnotationUseScopePostConstructPerDestroy {
	public AnnotationUseScopePostConstructPerDestroy(){
		System.out.println("构建了AnnotationUseScopePostConstructPerDestroy");
	}
	// 标注init方法
	@PostConstruct
	public void init(){
		System.out.println("执行初始化操作...");
	}
	public void doWork(){
		System.out.println("Do work...");
	}
	// 标注释放资源方法
	@PreDestroy
	public void destroys(){
		System.out.println("执行销毁操作");
	}
}
