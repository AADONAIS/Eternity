package cn.supermarket.manager.Dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.supermarket.manager.Dao.UserBeanDao;
import cn.supermarket.manager.entity.UserBean;
import cn.supermarket.manager.rowmapper.impl.UserRowMapper;
import cn.supermarket.manager.util.JDBCTemplate;

public class UserBeanImpl implements UserBeanDao {

	/**
	 * 添加用户
	 */
	@Override
	public int add(UserBean user) throws SQLException {
		String sql="insert into UserBean values(?,?,?,?,?,?,?,?);";
		return JDBCTemplate.executeUpdate(sql, user.getU_id(),user.getU_name(),user.getU_password(),user.getU_gender(),user.getU_age(),user.getU_phone(),user.getU_address(),user.getU_auth());
	}
 
	 
	/**
	 * 删除用户
	 */
	@Override
	public int delete(int index) throws SQLException {
		String sql="delete from UserBean where u_id=?";
		return JDBCTemplate.executeUpdate(sql,index);
	}

	/**
	 * 修改用户
	 */
	@Override
	public int modify(UserBean user) throws SQLException {
		String sql="update  UserBean set u_name=?,u_password=?,u_gender=?,u_age=?,u_phone=?,u_address=?,u_auth=? where u_id=?";
		return JDBCTemplate.executeUpdate(sql,user.getU_name(),user.getU_password(),user.getU_gender(),user.getU_age(),user.getU_phone(),user.getU_address(),user.getU_auth(),user.getU_id());
	}

	/**
	 * 查询所有用户
	 */
	@Override
	public List<UserBean> queryAll() throws SQLException {
		List<UserBean> userList=new ArrayList<UserBean>();
		String sql="select * from UserBean;";
		List<Object> list=JDBCTemplate.executeQuery(sql, new UserRowMapper());
		for (Object object : list) {
			userList.add((UserBean) object);
		}
		return userList;
	}

	/**
	 * 查询单个用户
	 */
	@Override
	public UserBean queryByName(String name) throws SQLException {
		String sql="select * from UserBean where u_name=?;";
		List<?> list = JDBCTemplate.executeQuery(sql, new UserRowMapper(), name);
		return list.size()>0 ? (UserBean)list.get(0) : null;
	}
}
