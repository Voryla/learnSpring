package com.zwk.spring_dao.jdbc_service;

import com.zwk.spring_dao.jdbc_dao.IEmployeeDao;
import com.zwk.spring_dao.jdbc_do.MyEmployee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpringDAOServiceImpl implements ISpringDAOService {
	@Autowired
	private IEmployeeDao employeeDao;
	@Override
	public void save(MyEmployee myEmployee) {
		employeeDao.save(myEmployee);
	}

	@Override
	public void update(MyEmployee myEmployee) {
		employeeDao.update(myEmployee);
	}

	@Override
	public MyEmployee get(int id) {
		return employeeDao.get(id);
	}

	@Override
	public void delete(int id) {
		employeeDao.delete(id);
	}

	@Override
	public List<MyEmployee> getAll() {
		return employeeDao.getAll();
	}
}
