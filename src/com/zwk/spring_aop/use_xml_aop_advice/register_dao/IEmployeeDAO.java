package com.zwk.spring_aop.use_xml_aop_advice.register_dao;

import com.zwk.spring_aop.use_xml_aop_advice.register_do.Employee;

public interface IEmployeeDAO {
	void save(Employee employee);
	void update(Employee employee);
}
