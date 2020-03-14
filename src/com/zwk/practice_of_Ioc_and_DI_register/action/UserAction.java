package com.zwk.practice_of_Ioc_and_DI_register.action;

import com.zwk.practice_of_Ioc_and_DI_register.register_do.User;
import com.zwk.practice_of_Ioc_and_DI_register.register_service.IUserService;
import lombok.Setter;

// 模拟Struts2的action 或者SpringMVC的Controller
public class UserAction {
	@Setter
	private IUserService service;
	public String execute(){
		System.out.println("注册请求");
		User user=new User();
		user.setName("zwk");
		user.setAge(18);
		service.register(user);
		return "success";
	}
}
