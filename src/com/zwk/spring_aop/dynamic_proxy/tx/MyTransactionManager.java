package com.zwk.spring_aop.dynamic_proxy.tx;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.InvalidTransactionException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;
import org.springframework.stereotype.Component;

@Component
public class MyTransactionManager implements javax.transaction.TransactionManager {

	@Override
	public void begin() throws NotSupportedException, SystemException {
		System.out.println("开启事务");
	}

	@Override
	public void commit() throws RollbackException, HeuristicMixedException, HeuristicRollbackException, SecurityException, IllegalStateException, SystemException {
		System.out.println("提交事务");
	}

	@Override
	public int getStatus() throws SystemException {
		return 0;
	}

	@Override
	public Transaction getTransaction() throws SystemException {
		return null;
	}

	@Override
	public void resume(Transaction transaction) throws InvalidTransactionException, IllegalStateException, SystemException {

	}

	@Override
	public void rollback() throws IllegalStateException, SecurityException, SystemException {
		System.out.println("回滚事务");
	}

	@Override
	public void setRollbackOnly() throws IllegalStateException, SystemException {

	}

	@Override
	public void setTransactionTimeout(int i) throws SystemException {

	}

	@Override
	public Transaction suspend() throws SystemException {
		return null;
	}
}
