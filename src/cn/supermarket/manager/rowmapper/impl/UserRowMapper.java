package cn.supermarket.manager.rowmapper.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.supermarket.manager.entity.UserBean;
import cn.supermarket.manager.rowmapper.RowMapper;

public class UserRowMapper implements RowMapper {

	@Override
	public Object getObjectMapper(ResultSet rs) throws SQLException {
		UserBean user=new UserBean();
		user.setU_id(rs.getInt("u_id"));
		user.setU_name(rs.getString("u_name"));
		user.setU_password(rs.getString("u_password"));
		user.setU_gender(rs.getString("u_gender"));
		user.setU_age(rs.getInt("u_age"));
		user.setU_phone(rs.getString("u_phone"));
		user.setU_address(rs.getString("u_address"));
		user.setU_auth(rs.getString("u_auth"));
		
		return user;
	}

}
