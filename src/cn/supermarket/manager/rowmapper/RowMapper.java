package cn.supermarket.manager.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 行转成实体类的对象 接口
 * @author Administrator
 *
 */
public interface RowMapper {
	public abstract Object getObjectMapper(ResultSet rs) throws SQLException;
}
