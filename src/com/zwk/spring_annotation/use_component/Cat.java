package com.zwk.spring_annotation.use_component;

import org.springframework.stereotype.Component;

/**
 * 使用@Component 注解
 * 1.在spring的xml种配置IOC解析器
 * 2.添加@Component注解
 * 3.@Component("myCat") 参数相当于xml文件种bean的id,
 * 如果不添加参数,spring会默认添加id,默认值为该类的首字母小写+全称,如Cat类默认值id为cat
 *
 * 作用:无需再xml种配置bean,只需添加IOC解析器 当spring容器创建时,
 * 会自动扫描给定路径包下的所有Component注解
 */
@Component("myCat")
public class Cat {

}
