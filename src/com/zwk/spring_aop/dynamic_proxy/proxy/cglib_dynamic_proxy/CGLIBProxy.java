package com.zwk.spring_aop.dynamic_proxy.proxy.cglib_dynamic_proxy;

import java.lang.reflect.Method;
import javax.transaction.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.stereotype.Service;

/**
 *	CGLIB动态代理，被代理的真是对象无需实现某个接口，而是将真实对象作为父类继承
 ** CGLIB动态代理实现org.springframework.cglib.proxy.InvocationHandler接口
 * 原理，org.springframework.cglib.proxy.InvocationHandler返回的代理对象继承了真实对象，
 * 并重写了toString,hashCode,equals
 */
@Service
public class CGLIBProxy implements InvocationHandler {
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
		Enhancer enhancer=new Enhancer();
		enhancer.setSuperclass(target.getClass());
		enhancer.setCallback(this);
		return (T)enhancer.create();
	}
	/**
	 * 	当外部调用代理类的重写过的方法时都会进入到这个方法
	 * 	args是外部调用动态代理的方法时传入的参数
	 * 	method参数自动传入的是外部调用动态代理的方法，使用invoke方法就可以直接调用真是对象的该方法
	 */

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result=null;
		myTransactionManager.begin();
		try{
			// 调用真实对象的方法
			result=method.invoke(target,args);
			myTransactionManager.commit();
		}catch (Exception e){
			myTransactionManager.rollback();
		}

		return result;
	}
}
