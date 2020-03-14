package com.zwk.spring_DI.use_Setter.di_collection;

import com.zwk.spring_DI.use_Setter.di_object.Person;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 集合注入
 */
public class CollectionBean {
	private Set<String> set;
	private List<String> list;
	private String[] array;
	private Map<String, String> map;
	//java中的properties文件是一种配置文件，主要用于表达配置信息，
	// 文件类型为*.properties，格式为文本文件，文件的内容是格式是"键=值"的格式
	private Properties prop;
	// 再演示一下为集合注入其他对象类型
	private List<Person> persons;


	public void setSet(Set<String> set) {
		this.set = set;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public void setArray(String[] array) {
		this.array = array;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	@Override
	public String toString() {
		return "CollectionBean{" +
				"\nset=" + set +
				",\n list=" + list +
				",\narray=" + Arrays.toString(array) +
				",\n map=" + map +
				",\n prop=" + prop +
				",\n pp=" + persons +
				'}';
	}
}
