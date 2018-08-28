package cn.supermarket.manager.transaction.impl;

import java.sql.Connection;
import java.sql.SQLException;

import cn.supermarket.manager.transaction.Transaction;
import cn.supermarket.manager.util.JDBCUtil;

public class TransactionImpl  implements Transaction{

	/**
	 * 事务开启
	 */
	@Override
	public void begin() {
		Connection connection;
		try {
			connection=JDBCUtil.getConnection();
			connection.setAutoCommit(false); //false为禁止自动提交
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 事务提交
	 */
	 
	@Override
	public void commit() {
		Connection connection;
		try {
			connection = JDBCUtil.getConnection();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    /**
     * 事务回滚
     */
	@Override
	public void rollback() {
		Connection connection;
		try {
			connection = JDBCUtil.getConnection();
			connection.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
