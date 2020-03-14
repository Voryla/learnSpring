package com.zwk.spring_DI.di_Property_place_holder;

import com.alibaba.druid.pool.DruidDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
public class PropertyPlaceHolderTest {
	// 手动连接
	@Test
	public void test() throws SQLException {
		DruidDataSource druidDataSource = new DruidDataSource();
		druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		druidDataSource.setUrl("jdbc:mysql://localhost:3306/users?serverTimezone=GMT&characterEncoding=utf-8&useSSL=false");
		druidDataSource.setUsername("root");
		druidDataSource.setPassword("123456");
		druidDataSource.setInitialSize(2);
		Connection conn = druidDataSource.getConnection();
		PreparedStatement preparedStatement = conn.prepareStatement("SELECT id,name,age FROM student");
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			System.out.println(resultSet.getLong("id") + ",");
			System.out.println(resultSet.getString("name") + ",");
			System.out.println(resultSet.getInt("age") + ",");
		}
	}

	// spring创建bean连接
	@Test
	public void test2() throws SQLException {
		DruidDataSource druidDataSource1 = (DruidDataSource) new ClassPathXmlApplicationContext(
				"classpath:com/zwk/spring_DI/di_Property_place_holder/PropertyPlaceHolderTest-context.xml").
				getBean("druidDataSource1");

		Connection conn = druidDataSource1.getConnection();
		PreparedStatement preparedStatement = conn.prepareStatement("SELECT id,name,age FROM student");
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			System.out.println(resultSet.getLong("id") + ",");
			System.out.println(resultSet.getString("name") + ",");
			System.out.println(resultSet.getInt("age") + ",");
		}
	}
	// 属性占位符方式
	// spring通过设置properties文件位置
	// <context:property-placeholder location="classpath:com/zwk/spring_DI/di_Property_place_holder/dbProperties"></context:property-placeholder>
	// 读取其中的属性创建bean
	// 读取方式<property name="url" value="${jdbc.url}"></property>
	@Test
	public void test3() throws SQLException {

		DruidDataSource druidDataSource2 = (DruidDataSource) new ClassPathXmlApplicationContext(
				"classpath:com/zwk/spring_DI/di_Property_place_holder/PropertyPlaceHolderTest-context.xml").
				getBean("druidDataSource2");

		Connection conn = druidDataSource2.getConnection();
		PreparedStatement preparedStatement = conn.prepareStatement("SELECT id,name,age FROM student");
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			System.out.println(resultSet.getLong("id") + ",");
			System.out.println(resultSet.getString("name") + ",");
			System.out.println(resultSet.getInt("age") + ",");
		}
	}

}
