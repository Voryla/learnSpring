package com.zwk.spring_aop.use_xml_aop_advice.register_service;

import com.zwk.spring_aop.use_xml_aop_advice.register_do.Employee;

public interface IEmployeeService {
	void save(Employee employee);
	void update(Employee employee);
}
