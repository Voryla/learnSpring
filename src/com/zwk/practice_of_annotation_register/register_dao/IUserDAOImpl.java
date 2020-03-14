package com.zwk.practice_of_annotation_register.register_dao;

import com.alibaba.druid.pool.DruidDataSource;
import com.zwk.practice_of_annotation_register.register_do.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
// 自动加载bean @Repository用来标识为dao组件 与其他组件作用相同都是用来自动加载bean
@Repository
public class IUserDAOImpl implements IUserDAO {
	// 自动加载DruidDataSource
	@Autowired
	private DruidDataSource druidDataSource;
	@Override
	public void save(User user) {
		try {
			Connection connection=druidDataSource.getConnection();
			String sql="INSERT INTO student(name,age) VALUES(?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,user.getName());
			preparedStatement.setInt(2,user.getAge());
			preparedStatement.executeUpdate();
		}catch (Exception e){

		}
		System.out.println("保存操作");
	}
}
