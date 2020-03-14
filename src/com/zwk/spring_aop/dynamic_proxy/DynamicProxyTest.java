package com.zwk.spring_aop.dynamic_proxy;

import com.zwk.spring_aop.dynamic_proxy.register_controller.EmployeeController;
import com.zwk.spring_aop.dynamic_proxy.register_do.Employee;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * jdk动态代理
 */
@SpringJUnitConfig
public class DynamicProxyTest {
	@Autowired
	private EmployeeController employeeController;
	@Test
	public void test(){
		Employee employee=new Employee();
		employee.setId(1);
		employee.setName("mmo");
		employee.setAge(20);
		employee.setSalary(new BigDecimal(500000));
		employeeController.executeUpdate(employee);
	}

}
