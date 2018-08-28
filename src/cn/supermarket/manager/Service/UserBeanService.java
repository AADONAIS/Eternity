package cn.supermarket.manager.Service;


import java.util.List;

import cn.supermarket.manager.entity.UserBean;
import cn.supermarket.manager.exception.MyException;

/**
 * �û�ҵ��ӿ�
 */
public interface UserBeanService {

	
	/**
	 * �û�ע��
	 */
	public abstract  void regist(UserBean user)throws MyException;
	/**
	 * �û���¼
	 */
	public abstract void login(UserBean user)throws MyException;
	/**
	 * �û�ע��
	 */
	public abstract void delete(int index)throws MyException;
	/**
	 * ��ѯ�����û�
	 */
	public abstract List<UserBean> queryUserAll()throws MyException;
	/**
	 * ��ѯ�����û�
	 */
	public abstract UserBean queryUser(String userName)throws MyException;
	/**
	 * �޸�����
	 * @param user
	 * @return
	 * @throws MyException
	 */
	public int changePassWord(UserBean user) throws MyException ;
	
	
	public void modify(UserBean user)throws MyException;
	
}
