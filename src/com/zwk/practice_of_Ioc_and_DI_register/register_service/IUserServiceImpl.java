package com.zwk.practice_of_Ioc_and_DI_register.register_service;

import com.zwk.practice_of_Ioc_and_DI_register.register_dao.IUserDAO;
import com.zwk.practice_of_Ioc_and_DI_register.register_do.User;
import lombok.Setter;

public class IUserServiceImpl implements IUserService {
	@Setter
	private IUserDAO dao;
	@Override
	public void register(User user) {
		System.out.println("注册操作");
		dao.save(user);
	}
}
