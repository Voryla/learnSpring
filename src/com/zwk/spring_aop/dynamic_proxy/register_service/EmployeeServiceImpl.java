package com.zwk.spring_aop.dynamic_proxy.register_service;

import com.zwk.spring_aop.dynamic_proxy.register_dao.IEmployeeDAO;
import com.zwk.spring_aop.dynamic_proxy.register_do.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private IEmployeeDAO employeeDAO;
	@Override
	public void save(Employee employee) {
		employeeDAO.save(employee);
	}

	@Override
	public void update(Employee employee) {
		employeeDAO.update(employee);
	}
}
