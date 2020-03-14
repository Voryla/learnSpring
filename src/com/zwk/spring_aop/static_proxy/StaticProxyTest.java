package com.zwk.spring_aop.static_proxy;

import com.zwk.spring_aop.static_proxy.register_controller.EmployeeController;
import com.zwk.spring_aop.static_proxy.register_do.Employee;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
public class StaticProxyTest {
	@Autowired
	private EmployeeController employeeController;
	@Test
	public void test(){
		Employee employee=new Employee();
		employee.setName("zwk");
		employee.setAge(20);
		employee.setSalary(new BigDecimal(500000));
		employeeController.executeSave(employee);
	}
}
