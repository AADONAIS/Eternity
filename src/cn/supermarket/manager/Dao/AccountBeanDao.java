package cn.supermarket.manager.Dao;

import java.sql.SQLException;
import java.util.List;

import cn.supermarket.manager.entity.AccountBean;



public interface AccountBeanDao {

	/**
	 * ����˵�
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public abstract int add(AccountBean account)throws SQLException;
	
	/**
	 * ɾ���˵�
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public abstract int delete(int index,AccountBean accountBean)throws SQLException;
	
	/**
	 * �޸��˵�
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public abstract int modify(int index,AccountBean accountBean)throws SQLException;
	
	/**
	 * ��ѯ�����˵�
	 * @return
	 * @throws SQLException
	 */
	public abstract List<AccountBean> queryAll()throws SQLException;
	
	/**
	 * ��ѯ�����˵�
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public abstract AccountBean queryByName(String name)throws SQLException;
	
	/**
	 * 根据名字和是否付款查询账单
	 * @param name
	 * @param ispay
	 * @return
	 * @throws SQLException
	 */
	public abstract List<AccountBean> queryByNameandispay(int ispay,String name)throws SQLException;
	
}
