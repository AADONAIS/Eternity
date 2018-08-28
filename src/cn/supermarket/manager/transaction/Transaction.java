package cn.supermarket.manager.transaction;

/**
 * 事务管理接口
 * @author Administrator
 *
 */
public interface Transaction {

	/**
	 * 事务开启
	 */
	public  abstract  void begin();
	/**
	 * 事务提交
	 */
	public  abstract  void commit();
	/**
	 * 事务回滚
	 */
	public  abstract  void rollback();
}
