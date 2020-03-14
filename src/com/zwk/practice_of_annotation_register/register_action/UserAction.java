package com.zwk.practice_of_annotation_register.register_action;

import com.zwk.practice_of_annotation_register.register_do.User;
import com.zwk.practice_of_annotation_register.register_service.IUserService;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
// 自动加载bean @Controller用来标识为控制层组件 与其他组件作用相同都是用来自动加载bean
@Controller
public class UserAction {
	// 自动加载IUserService  @Resource==@Autowired
	@Resource
	IUserService iUserService;
	public void execute(){
		System.out.println("注册请求");
		User user=new User();
		user.setName("voryla");
		user.setAge(18);
		iUserService.register(user);
	}
}
