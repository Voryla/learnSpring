package com.zwk.spring_aop.dynamic_proxy.register_controller;

import com.zwk.spring_aop.dynamic_proxy.proxy.cglib_dynamic_proxy.CGLIBProxy;
import com.zwk.spring_aop.dynamic_proxy.proxy.jdk_dynamic_proxy.EmployeeServiceProxy;
import com.zwk.spring_aop.dynamic_proxy.register_do.Employee;
import com.zwk.spring_aop.dynamic_proxy.register_service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class EmployeeController {
	// 自动加载jdk动态代理对象
	@Autowired
	private EmployeeServiceProxy employeeServiceProxy;
	// 创建service接口类型引用，接受自动加载的service实现类的bean，
	// 因为后面要接受代理之后的对象，jdk动态代理时，使用接口类型引用接受，cglib使用父类对象，或真是对象接受
	@Autowired
	private IEmployeeService iEmployeeService;
	@Autowired
	private CGLIBProxy cglibProxy;
	// 使用jdk动态代理
	public void executeSave(Employee employee) {
		// 将需要代理的对象传入动态代理类
		employeeServiceProxy.setTarget(iEmployeeService);
		// 接受将真实对象包装后的代理类对象
		iEmployeeService=employeeServiceProxy.getProxyObject();
		// 调用代理类的方法
		iEmployeeService.save(employee);
	}
	// 使用cglib动态代理
	public void executeUpdate(Employee employee) {
		cglibProxy.setTarget(iEmployeeService);
		iEmployeeService=cglibProxy.getProxyObject();
		iEmployeeService.update(employee);
	}
}
