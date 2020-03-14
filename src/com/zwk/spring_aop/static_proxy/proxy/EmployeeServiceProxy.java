package com.zwk.spring_aop.static_proxy.proxy;

import com.zwk.spring_aop.static_proxy.register_do.Employee;
import com.zwk.spring_aop.static_proxy.register_service.EmployeeServiceImpl;
import com.zwk.spring_aop.static_proxy.register_service.IEmployeeService;
import javax.transaction.SystemException;
import javax.transaction.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceProxy implements IEmployeeService {
	// 事务管理器
	private TransactionManager myTransactionManager;
	// 真实对象/委托对象
	private IEmployeeService target;

	// 自动加载事务管理器
	@Autowired
	public void setTransactionManager(TransactionManager myTransactionManager) {
		this.myTransactionManager = myTransactionManager;
	}

	public void setTarget(EmployeeServiceImpl target) {
		this.target = target;
	}

	@Override
	public void save(Employee employee) {
		try {
			myTransactionManager.begin();
			target.save(employee);
			myTransactionManager.commit();
		} catch (Exception e) {
			try {
				myTransactionManager.rollback();
			} catch (SystemException ex) {
				ex.printStackTrace();
			}
		}

	}

	@Override
	public void update(Employee employee) {
		try {
			myTransactionManager.begin();
			target.update(employee);
			myTransactionManager.commit();
		} catch (Exception e) {
			try {
				myTransactionManager.rollback();
			} catch (SystemException ex) {
				ex.printStackTrace();
			}
		}
	}
}
