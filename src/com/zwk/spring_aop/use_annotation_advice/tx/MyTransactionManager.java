package com.zwk.spring_aop.use_annotation_advice.tx;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component // 自动装载增强类的bean
@Aspect // 配置一个切面
public class MyTransactionManager {
	// 配置切入点
	@Pointcut(value = "execution(* com.zwk.spring_aop.use_annotation_advice.register_service.*.*(..))")
	public void pointcut() {

	}

	@Before(value = "pointcut()")
	public void begin(JoinPoint joinPoint) {
		System.out.println(joinPoint.getTarget().getClass());
		System.out.println("开启事务");
	}

	@AfterReturning(value = "pointcut()")
	public void commit(JoinPoint joinPoint) {
		System.out.println("提交事务");
	}

	@AfterThrowing(value = "pointcut()", throwing = "ex")
	public void rollback(JoinPoint joinPoint, Throwable ex) {
		System.out.println("错误信息" + ex.getMessage());
		System.out.println("回滚事务");
	}

	@After(value = "pointcut()")
	public void close(JoinPoint joinPoint) {
		System.out.println("释放资源");
	}

	@Around(value = "pointcut()")
	public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint) {
		Object result = null;
		System.out.println("开启事务");
		try {
			System.out.println("提交事务");
			// 需要自己调用方法
			result = proceedingJoinPoint.proceed();
		} catch (Throwable throwable) {
			System.out.println("回滚事务!!");
		} finally {
			System.out.println("释放资源");
		}
		return result;
	}
}
