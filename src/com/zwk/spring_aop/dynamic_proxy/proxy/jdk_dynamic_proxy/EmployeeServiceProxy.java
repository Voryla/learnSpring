package com.zwk.spring_aop.dynamic_proxy.proxy.jdk_dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import javax.transaction.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 注意!!! jdk代理类需要被代理的真实对象要实现了某个接口才可以做动态代理
 * jdk动态代理实现java.lang.reflect.InvocationHandler接口
 * 原理， Proxy.newProxyInstance返回的代理对象继承了真实对象的所有接口，并重写了toString,hashCode,equals
 */
@Service
public class EmployeeServiceProxy implements InvocationHandler {
	// 事务管理器
	@Autowired
	private TransactionManager myTransactionManager;
	// 真实对象/委托对象
	private Object target;

	public void setTarget(Object target) {
		this.target = target;
	}

	/**
	 * 获取动态代理对象
	 * @param <T> 因为动态代理并不确定给谁做代理所有返回类型为泛型，外部用什么类型接受，就返回什么类型
	 * @return
	 */
	public <T> T getProxyObject() {
		// Proxy.newProxyInstance参数1真实对象的class，参数二真实对象所实现的接口，
		// 参数三实现java.lang.reflect.InvocationHandler接口的类，实现了该接口就代表是一个工作类
		return  (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),
				target.getClass().getInterfaces(),
				this);
	}
	/**
	 * 	当外部调用代理类的重写过的方法时都会进入到这个方法
	 * 	args是外部调用动态代理的方法时传入的参数
	 * 	method参数自动传入的是外部调用动态代理的方法，使用invoke方法就可以直接调用真是对象的该方法
 	 *  该方法内不要使用toString方法，会导致死循环一直重复调用invoke方法，因为toString,hashcode,equals
	 *  三个方法均被代理类重写，也就是调用的时候会再次进入到invoke方法中
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
