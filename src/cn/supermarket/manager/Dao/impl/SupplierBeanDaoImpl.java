package cn.supermarket.manager.Dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.supermarket.manager.Dao.SupplierBeanDao;
import cn.supermarket.manager.entity.SupplierBean;
import cn.supermarket.manager.entity.UserBean;

import cn.supermarket.manager.rowmapper.impl.SupplierBeanRowMapper;
import cn.supermarket.manager.rowmapper.impl.UserRowMapper;
import cn.supermarket.manager.util.JDBCTemplate;

public class SupplierBeanDaoImpl implements SupplierBeanDao{

	/**
	 * ��ӹ�Ӧ��
	 */
	@Override
	public int add(SupplierBean supplier) throws SQLException {
		String sql="insert into SupplierBean values(?,?,?,?,?,?,?);";
		return JDBCTemplate.executeUpdate(sql,supplier.getS_id(),supplier.getS_name(),supplier.getS_info(),supplier.getS_linkman(),supplier.getS_phone(),supplier.getS_address(),supplier.getS_faxes() );
	}


	/**
	 * ɾ��Ӧ��
	 */
	@Override
	public int delete(int index,SupplierBean supplier) throws SQLException {
		String sql="delete from SupplierBean where s_id=?";
		return JDBCTemplate.executeUpdate(sql,index);
	}

	/**
	 * �޸Ĺ�Ӧ��
	 */
	@Override
	public int modify(SupplierBean supplier) throws SQLException {
		String sql="update table SupplierBean s_name=?,s_info=?,s_linkman=?,s_phone=?,s_phone=?,s_address=?,s_faxes=? where s_id=?;";
		return JDBCTemplate.executeUpdate(sql, supplier.getS_name(),supplier.getS_info(),supplier.getS_linkman(),supplier.getS_phone(),supplier.getS_address(),supplier.getS_faxes());
	}

	/**
	 * ��ѯ��Ӧ��
	 */
	@Override
	public List<SupplierBean> queryAll() throws SQLException {
		List<SupplierBean> supplierList=new ArrayList<SupplierBean>();
		String sql="select * from SupplierBean;";
		List<Object> list=JDBCTemplate.executeQuery(sql, new SupplierBeanRowMapper());
		for (Object object : list) {
		    supplierList.add((SupplierBean) object);	
		}
		return supplierList;
	}

	/**
	 * ��ѯ������Ӧ��
	 */
	@Override
	public SupplierBean queryByName(String name) throws SQLException {
		String sql="select * from SupplierBean where s_name=?";
		List<?> list = JDBCTemplate.executeQuery(sql, new SupplierBeanRowMapper(), name);
		return list.size()>0 ? (SupplierBean)list.get(0) : null;
	}

}
