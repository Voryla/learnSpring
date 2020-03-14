package com.zwk.spring_dao.jdbc_controller;

import com.zwk.spring_dao.jdbc_do.MyEmployee;
import com.zwk.spring_dao.jdbc_service.ISpringDAOService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JDBCSpringController {
	@Autowired
	private ISpringDAOService springDAOService;
	public void executeSave(MyEmployee myEmployee){
		springDAOService.save(myEmployee);
	}
	public void executeUpdate(MyEmployee myEmployee){
		springDAOService.update(myEmployee);
	}
	public List<MyEmployee> getAll(){
		return springDAOService.getAll();
	}

	public MyEmployee get(int id) {
		return springDAOService.get(id);
	}
}
