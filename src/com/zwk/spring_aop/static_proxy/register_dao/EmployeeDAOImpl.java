package com.zwk.spring_aop.static_proxy.register_dao;

import com.alibaba.druid.pool.DruidDataSource;
import com.zwk.spring_aop.static_proxy.register_do.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAOImpl implements IEmployeeDAO{
	@Autowired
	private  DruidDataSource druidDataSource;
	@Override
	public void save(Employee employee) {
		try {
			Connection connection=druidDataSource.getConnection();
			String sql="INSERT INTO employee(name,age,salary) VALUES (?,?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,employee.getName());
			preparedStatement.setInt(2,employee.getAge());
			preparedStatement.setBigDecimal(3,employee.getSalary());
			preparedStatement.executeUpdate();
		}catch (Exception e){
			e.printStackTrace();
		}

	}

	@Override
	public void update(Employee employee) {
		try {
			Connection connection=druidDataSource.getConnection();
			String sql="UPDATE employee SET name=?,age=?,salary=? WHERE id=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,employee.getName());
			preparedStatement.setInt(2,employee.getAge());
			preparedStatement.setBigDecimal(3,employee.getSalary());
			preparedStatement.setInt(4,employee.getId());
			preparedStatement.executeUpdate();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
