package cn.supermarket.manager.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ��ת��ʵ����Ķ��� �ӿ�
 * @author Administrator
 *
 */
public interface RowMapper {
	public abstract Object getObjectMapper(ResultSet rs) throws SQLException;
}
