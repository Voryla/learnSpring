package com.zwk.spring_aop.static_proxy.register_controller;

import com.zwk.spring_aop.static_proxy.proxy.EmployeeServiceProxy;
import com.zwk.spring_aop.static_proxy.register_do.Employee;
import com.zwk.spring_aop.static_proxy.register_service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeServiceProxy employeeServiceProxy;
	@Autowired
	private EmployeeServiceImpl employeeService;

	public void executeSave(Employee employee) {
		employeeServiceProxy.setTarget(employeeService);
		employeeServiceProxy.save(employee);
	}
	public void executeUpdate(Employee employee) {
		employeeServiceProxy.update(employee);
	}
}
