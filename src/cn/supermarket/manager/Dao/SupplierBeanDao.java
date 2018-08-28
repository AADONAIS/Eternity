package cn.supermarket.manager.Dao;

import java.sql.SQLException;
import java.util.List;

import cn.supermarket.manager.entity.AccountBean;
import cn.supermarket.manager.entity.SupplierBean;

public interface SupplierBeanDao {

	/**
	 * ��ӹ�Ӧ��
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public abstract int add(SupplierBean supplier)throws SQLException;
	
	/**
	 * ɾ���˵�
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public abstract int delete(int index,SupplierBean supplier)throws SQLException;
	
	/**
	 * �޸��˵�
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public abstract int modify(SupplierBean supplier)throws SQLException;
	
	/**
	 * ��ѯ�����˵�
	 * @return
	 * @throws SQLException
	 */
	public abstract List<SupplierBean> queryAll()throws SQLException;
	
	/**
	 * ��ѯ�����˵�
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public abstract SupplierBean queryByName(String name)throws SQLException;
}
