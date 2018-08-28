package cn.supermarket.manager.Dao;

import java.sql.SQLException;
import java.util.List;

import cn.supermarket.manager.entity.UserBean;

public interface UserBeanDao {

	/**
	 * ����û�
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public abstract int add(UserBean user)throws SQLException;
	
	/**
	 * ɾ���û�
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public abstract int delete(int index)throws SQLException;
	
	/**
	 * �޸��û�
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public abstract int modify(UserBean user)throws SQLException;
	
	/**
	 * ��ѯ�����û�
	 * @return
	 * @throws SQLException
	 */
	public abstract List<UserBean> queryAll()throws SQLException;
	
	/**
	 * ��ѯ�����û�
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public abstract UserBean queryByName(String name)throws SQLException;
	
	
	
	
}
