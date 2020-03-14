package com.zwk.practice_of_Ioc_and_DI_register.register_dao;

import com.zwk.practice_of_Ioc_and_DI_register.register_do.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.sql.DataSource;
import lombok.Setter;

public class IUserDAOImpl implements IUserDAO {
	@Setter
	private DataSource dataSource;

	@Override
	public void save(User user) {
		System.out.println("保存操作");
		try{
			Connection connection = dataSource.getConnection();
			String sql = "INSERT  INTO student(name,age) VALUES (?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setInt(2, user.getAge());
			preparedStatement.executeUpdate();
		} catch (Exception e) {

		}

	}
}
