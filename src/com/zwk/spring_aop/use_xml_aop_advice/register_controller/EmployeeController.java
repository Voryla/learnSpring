package com.zwk.spring_aop.use_xml_aop_advice.register_controller;

import com.zwk.spring_aop.use_xml_aop_advice.register_do.Employee;
import com.zwk.spring_aop.use_xml_aop_advice.register_service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class EmployeeController {

	@Autowired
	private IEmployeeService employeeService;

	public void executeSave(Employee employee) {
		System.out.println(employeeService.getClass());
		employeeService.save(employee);
	}
	public void executeUpdate(Employee employee) {
		employeeService.update(employee);
	}
}
