package com.zwk.spring_aop.dynamic_proxy.register_dao;

import com.zwk.spring_aop.dynamic_proxy.register_do.Employee;

public interface IEmployeeDAO {
	void save(Employee employee);
	void update(Employee employee);
}
