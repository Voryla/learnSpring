package com.zwk.practice_of_Ioc_and_DI_register;

import com.zwk.practice_of_Ioc_and_DI_register.action.UserAction;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// 用户注册  xml版
public class RegisterTest {

	private UserAction userAction;
	@Test
	public void test(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("com/zwk/practice_of_Ioc_and_DI_register/RegisterTest-context.xml");
		userAction=applicationContext.getBean("userAction", UserAction.class);
		userAction.execute();
	}
}
