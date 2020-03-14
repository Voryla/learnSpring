package com.zwk.practice_of_annotation_register;


import com.zwk.practice_of_annotation_register.register_action.UserAction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
// 用户注册注解版
@SpringJUnitConfig
public class RegisterTest {
	// 自动加载UserAction
	@Autowired
	private UserAction userAction;

	@Test
	public void test() {

		userAction.execute();
	}
}
