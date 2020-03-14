package com.zwk.spring_aop.dynamic_proxy.proxy.cglib_dynamic_proxy;

import java.lang.reflect.Method;
import javax.transaction.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * CGLIB 拦截器写法
 */
public class CGlibMethodInterceptor implements MethodInterceptor {
	// 事务管理器
	@Autowired
	private TransactionManager myTransactionManager;
	// 真实对象/委托对象
	private Object target;

	public void setTarget(Object target) {
		this.target = target;
	}

	// 获取动态代理对象
	public <T> T getProxyObject() {
		return (T)Enhancer.create(target.getClass(),this);
	}
	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		Object result=null;
		myTransactionManager.begin();
		try{
			// 调用真实对象的方法
			result=method.invoke(target,objects);
			myTransactionManager.commit();
		}catch (Exception e){
			myTransactionManager.rollback();
		}

		return result;
	}
}
