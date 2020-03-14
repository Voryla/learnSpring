package com.zwk.spring_aop.use_xml_aop_advice.tx;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class MyTransactionManager {

	public void begin(JoinPoint joinPoint) {
		System.out.println(joinPoint.getTarget().getClass());
		System.out.println("开启事务");
	}

	public void commit(JoinPoint joinPoint) {
		System.out.println("提交事务");
	}


	public void rollback(JoinPoint joinPoint, Throwable ex) {
		System.out.println("错误信息" + ex.getMessage());
		System.out.println("回滚事务");
	}

	public void close(JoinPoint joinPoint) {
		System.out.println("释放资源");
	}

	public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint) {
		Object result = null;
		System.out.println("开启事务");
		try {
			System.out.println("提交事务");
			// 需要自己调用方法
			result=proceedingJoinPoint.proceed();
		} catch (Throwable throwable) {
			System.out.println("回滚事务!!");
		} finally {
			System.out.println("释放资源");
		}
		return result;
	}
}
