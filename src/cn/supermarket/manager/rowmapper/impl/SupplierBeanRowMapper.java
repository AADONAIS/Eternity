package cn.supermarket.manager.rowmapper.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.supermarket.manager.entity.SupplierBean;
import cn.supermarket.manager.rowmapper.RowMapper;

public class SupplierBeanRowMapper implements RowMapper {

	@Override
	public Object getObjectMapper(ResultSet rs) throws SQLException {
		SupplierBean supplierBean=new SupplierBean();
		supplierBean.setS_id(rs.getInt("s_id"));
		supplierBean.setS_name(rs.getString("s_name"));
		supplierBean.setS_info(rs.getString("s_info"));
		supplierBean.setS_linkman(rs.getString("s_linkman"));
		supplierBean.setS_phone(rs.getString("s_phone"));
		supplierBean.setS_address(rs.getString("s_address"));
		supplierBean.setS_faxes(rs.getString("s_faxes"));
		return supplierBean;
	}

}
