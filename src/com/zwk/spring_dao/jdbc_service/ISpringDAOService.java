package com.zwk.spring_dao.jdbc_service;

import com.zwk.spring_dao.jdbc_do.MyEmployee;
import java.util.List;

public interface ISpringDAOService {
	void save(MyEmployee myEmployee);
	void update(MyEmployee myEmployee);
	MyEmployee get(int id);
	void delete(int id);
	List<MyEmployee> getAll();
}
