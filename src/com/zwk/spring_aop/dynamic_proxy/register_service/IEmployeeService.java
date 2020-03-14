package com.zwk.spring_aop.dynamic_proxy.register_service;

import com.zwk.spring_aop.dynamic_proxy.register_do.Employee;

public interface IEmployeeService {
	void save(Employee employee);
	void update(Employee employee);
}
