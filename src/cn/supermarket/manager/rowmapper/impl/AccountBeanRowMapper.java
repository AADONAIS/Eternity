package cn.supermarket.manager.rowmapper.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import cn.supermarket.manager.entity.AccountBean;
import cn.supermarket.manager.rowmapper.RowMapper;

public class AccountBeanRowMapper implements RowMapper{

	@Override
	public Object getObjectMapper(ResultSet rs) throws SQLException {
		AccountBean accountBean=new AccountBean();
		accountBean.setA_id(rs.getInt("a_id"));
		accountBean.setA_name(rs.getString("a_name"));
		accountBean.setA_nums(rs.getInt("a_nums"));
		accountBean.setA_amount(rs.getDouble("a_amount"));
		accountBean.setA_unit(rs.getString("a_unit"));
		accountBean.setA_ispayed(rs.getInt("a_ispayed"));
		accountBean.setS_id(rs.getInt("s_id"));
		accountBean.setS_name(rs.getString("s_name"));
		accountBean.setA_Info(rs.getString("a_Info"));
		accountBean.setA_Date(rs.getDate("a_Date"));
		return accountBean;
	}

}
