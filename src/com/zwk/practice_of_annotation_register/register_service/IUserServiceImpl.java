package com.zwk.practice_of_annotation_register.register_service;

import com.zwk.practice_of_annotation_register.register_dao.IUserDAO;
import com.zwk.practice_of_annotation_register.register_do.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// 自动加载bean @Service用来标识为业务层组件 与其他组件作用相同都是用来自动加载bean
@Service
public class IUserServiceImpl implements IUserService {
	// 自动加载IUserDAO
	@Autowired
	IUserDAO iUserDAO;
	@Override
	public void register(User user) {
		System.out.println("注册操作");
		iUserDAO.save(user);
	}
}
