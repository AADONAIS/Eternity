package cn.supermarket.manager.Dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.supermarket.manager.Dao.AccountBeanDao;
import cn.supermarket.manager.entity.AccountBean;

import cn.supermarket.manager.rowmapper.impl.AccountBeanRowMapper;
import cn.supermarket.manager.util.JDBCTemplate;

public class AccountDaoImpl implements AccountBeanDao{

	/**
	 * ����˵�
	 */
	@Override
	public int add(AccountBean account) throws SQLException {
		String sql="insert into AccountBean values(?,?,?,?,?,?,?,?,?,?);";
		return JDBCTemplate.executeUpdate(sql, account.getA_id(),account.getA_name(),account.getA_nums(),account.getA_amount(),account.getA_unit(),account.getA_ispayed(),account.getS_id(),account.getS_name(),account.getA_Info(),account.getA_Date());
	}

	
	/**
	 * ɾ���˵�
	 */
	@Override
	public int delete(int index,AccountBean accountBean) throws SQLException {
		String sql="delete from AccountBean where a_id=?";
		return JDBCTemplate.executeUpdate(sql, index);
	}

	/**
	 * �޸��˵�
	 */
	@Override
	public int modify(int index,AccountBean accountBean) throws SQLException {
		String sql="update table AccountBean set a_name=?,a_nums=?,a_amount=?,a_unit=?,a_ispayed=? where a_id=?";
		return JDBCTemplate.executeUpdate(sql, accountBean.getA_name(),accountBean.getA_nums(),accountBean.getA_amount(),accountBean.getA_unit(),accountBean.getA_ispayed(),index);
	}

	/**
	 * ��ѯ�����˵�
	 */
	@Override
	public List<AccountBean> queryAll() throws SQLException {
		List<AccountBean> accountList=new ArrayList<AccountBean>();
		String sql="select * from AccountBean;";
		List<Object> list=JDBCTemplate.executeQuery(sql,new AccountBeanRowMapper());
		for (Object object : list) {
			accountList.add((AccountBean) object);
		}
		return accountList;
	}
 
	/**
	 * ��ѯ�����˵�
	 */
	@Override
	public AccountBean queryByName(String name) throws SQLException {
		String sql="select * from AccountBean where a_name=?;";
		List<?> list=JDBCTemplate.executeQuery(sql, new AccountBeanRowMapper(),name);
		return list.size()>0 ? (AccountBean)list.get(0) : null;
	}


	@Override
	public List<AccountBean> queryByNameandispay(int ispay,String name) throws SQLException {
		List<Object> list=null;
		String sql="select * from AccountBean where a_ispayed=? and a_name=?;";
		list=JDBCTemplate.executeQuery(sql, new AccountBeanRowMapper(), ispay,name);
		List<AccountBean> accountList=new ArrayList<AccountBean>();
		for (Object object : list) {
			accountList.add((AccountBean) object);
		}
		return accountList;
	}

}
