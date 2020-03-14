package com.zwk.spring_dao.jdbc_dao;

import com.zwk.spring_dao.jdbc_do.MyEmployee;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl implements IEmployeeDao {
	// spring 提供的jdbc需要添加spring-tx-5.0.0.RELEASE.jar spring-aop-5.0.0.RELEASE.jar包
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcDaoSupport;
	@Autowired
	@Qualifier(value = "druidDAO")
	public void setJdbcTemplate(DataSource druidDataSource) {
		this.jdbcTemplate = new JdbcTemplate(druidDataSource);
		this.namedParameterJdbcDaoSupport=new NamedParameterJdbcTemplate(druidDataSource);
	}

	@Override
	public void save(MyEmployee myEmployee) {
		jdbcTemplate.update("INSERT INTO employee(name,age,salary) VALUES (?,?,?)",
				myEmployee.getName(),myEmployee.getAge(),myEmployee.getSalary());
		namedParameterJdbcDaoSupport.
				update("INSERT INTO employee(name,age,salary) VALUES (:name,age,salary)",
						new HashMap(){{this.put("name",myEmployee.getName());this.put("age",myEmployee.getAge());}});

	}

	@Override
	public void update(MyEmployee myEmployee) {
		jdbcTemplate.update("UPDATE employee SET name=? ,age=?,salary=? WHERE id=?",
				myEmployee.getName(),myEmployee.getAge(),myEmployee.getSalary(),myEmployee.getId());
	}

	@Override
	public void delete(int id) {
		jdbcTemplate.update("DELETE FROM employee WHERE id=?", id);
	}

	@Override
	public MyEmployee get(int id) {
		MyEmployee myEmployee=null;
		try {
			myEmployee=jdbcTemplate.queryForObject("SELECT id,name,age,salary FROM employee WHERE id=?", (resultSet,i)->{
				MyEmployee myEmployees=new MyEmployee();
				myEmployees.setId(resultSet.getInt("id"));
				myEmployees.setName(resultSet.getString("name"));
				myEmployees.setAge(resultSet.getInt("age"));
				myEmployees.setSalary(resultSet.getBigDecimal("salary"));
				return myEmployees;
			},id);
		}catch (Exception e){
			myEmployee=null;
		}
		return myEmployee;
		/**
		 * List<MyEmployee> myEmployees=jdbcTemplate.query("SELECT id,name,age,salary FROM employee WHERE id=?",new Object[]{id}, new RowMapper<MyEmployee>() {
		 *                        @Override
		 *            public MyEmployee mapRow(ResultSet resultSet, int i) throws SQLException {
		 * 				MyEmployee myEmployee=new MyEmployee();
		 * 				myEmployee.setId(resultSet.getInt("id"));
		 * 				myEmployee.setAge(resultSet.getInt("age"));
		 * 				myEmployee.setSalary(resultSet.getBigDecimal("salary"));
		 * 				myEmployee.setName(resultSet.getString("name"));
		 * 				return myEmployee;
		 *            }        * 		});
		 * 		return myEmployees.size()==1?myEmployees.get(0):null;
		 */
	}

	@Override
	public List<MyEmployee> getAll() {
		return jdbcTemplate.query("SELECT id,name,age,salary FROM employee", new RowMapper<MyEmployee>() {
			@Override
			public MyEmployee mapRow(ResultSet resultSet, int i) throws SQLException {
				MyEmployee myEmployee=new MyEmployee();
				myEmployee.setId(resultSet.getInt("id"));
				myEmployee.setName(resultSet.getString("name"));
				myEmployee.setAge(resultSet.getInt("age"));
				myEmployee.setSalary(resultSet.getBigDecimal("salary"));
				return myEmployee;
			}
		});
	}
}
