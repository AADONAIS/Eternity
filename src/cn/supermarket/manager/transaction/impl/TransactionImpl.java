package cn.supermarket.manager.transaction.impl;

import java.sql.Connection;
import java.sql.SQLException;

import cn.supermarket.manager.transaction.Transaction;
import cn.supermarket.manager.util.JDBCUtil;

public class TransactionImpl  implements Transaction{

	/**
	 * ������
	 */
	@Override
	public void begin() {
		Connection connection;
		try {
			connection=JDBCUtil.getConnection();
			connection.setAutoCommit(false); //falseΪ��ֹ�Զ��ύ
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * �����ύ
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
     * ����ع�
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
