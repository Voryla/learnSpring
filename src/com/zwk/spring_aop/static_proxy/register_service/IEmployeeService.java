package com.zwk.spring_aop.static_proxy.register_service;

import com.zwk.spring_aop.static_proxy.register_do.Employee;

public interface IEmployeeService {
	void save(Employee employee);
	void update(Employee employee);
}
