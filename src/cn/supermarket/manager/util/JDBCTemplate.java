package cn.supermarket.manager.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.supermarket.manager.rowmapper.RowMapper;

public final class JDBCTemplate {

	/**
	 * ��ɾ�ķ���
	 */
	public static int executeUpdate(String sql,Object ...param) throws SQLException {
		int rows = -1;
		Connection conn = JDBCUtil.getConnection();//获取连接
		PreparedStatement ps = conn.prepareStatement(sql);
		if(null != param && param.length>0) {
			for (int i = 0; i < param.length; i++) {
				ps.setObject((i+1), param[i]);// ռλ���1��ʼ   �±��0��ʼ
			}
		}
		rows = ps.executeUpdate();
		close(null,ps);
		return rows;
	}
	
	/**
	 *��ѯ����
	 */
	public static   List<Object> executeQuery(String sql,RowMapper rowmapper,Object ...param) throws SQLException {
		List<Object> list = new ArrayList<Object>();
		Connection conn = JDBCUtil.getConnection();//��ȡ����
		PreparedStatement ps = conn.prepareStatement(sql);
		if(null != param && param.length>0) {
			for (int i = 0; i < param.length; i++) {
				ps.setObject((i+1), param[i]);// ռλ���1��ʼ   �±��0��ʼ
			}
		}
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Object obj = rowmapper.getObjectMapper(rs);
			list.add(obj);
		}
		close(rs,ps);
		return list;
	}
	/*
	 * �ر�
	 */
	private static void close(ResultSet rs,PreparedStatement ps) throws SQLException {
		if(null != rs) {
			rs.close();
		}
		if(null != ps) {
			ps.close();
		}
	}
	
}

