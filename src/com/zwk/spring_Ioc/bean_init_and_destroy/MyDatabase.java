package com.zwk.spring_Ioc.bean_init_and_destroy;

/**
 * 在bean单例时spring可以自动的执行释放资源，如果是多例时不会自动执行释放资源的操作,需要手动释放
 */
public class MyDatabase {
	public MyDatabase(){
		System.out.println("构建数据库对象");
	}
	public void open(){
		System.out.println("打开数据库连接");
	}
	public void close(){
		System.out.println("关闭数据库连接");
	}
	public void doWork(){
		System.out.println("做CRUD");
	}
}
