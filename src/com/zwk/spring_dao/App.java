package com.zwk.spring_dao;

import com.zwk.spring_dao.jdbc_controller.JDBCSpringController;
import com.zwk.spring_dao.jdbc_do.MyEmployee;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
public class App {
	@Autowired
	private JDBCSpringController controller;
	@Test
	public void testSave(){
		MyEmployee myEmployee=new MyEmployee();
		myEmployee.setName("tony");
		myEmployee.setAge(32);
		myEmployee.setSalary(new BigDecimal(333));
		controller.executeSave(myEmployee);
	}
	@Test
	public void testUpdate(){
		MyEmployee myEmployee=new MyEmployee();
		myEmployee.setId(3);
		myEmployee.setName("乔峰");
		myEmployee.setAge(32);
		myEmployee.setSalary(new BigDecimal(333));
		controller.executeUpdate(myEmployee);
	}
	@Test
	public void testGetAll(){
		for(MyEmployee e:controller.getAll()){
			System.out.println(e);
		}
	}
	@Test
	public void testGet(){
		System.out.println(controller.get(1));
	}
}
