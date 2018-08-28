package cn.supermarket.manager.Service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.UserDataHandler;

import cn.supermarket.manager.Dao.UserBeanDao;
import cn.supermarket.manager.Service.UserBeanService;
import cn.supermarket.manager.entity.UserBean;
import cn.supermarket.manager.exception.MyException;
import cn.supermarket.manager.object.ObjectFactory;
import cn.supermarket.manager.transaction.Transaction;
import cn.supermarket.manager.util.Util;

public class UserBeanServiceImpl implements UserBeanService {

	
	private UserBeanDao userBeanDao=(UserBeanDao) ObjectFactory.getInstance("UserBeanDao");
	private Transaction transaction=(Transaction) ObjectFactory.getInstance("Transaction");

	
	/**
	 * �û�ע��
	 */
	@Override
	public void regist(UserBean user) throws MyException {
		if(Util.isEmpty(user.getU_name())) {
			throw new MyException("用户名为空");
		}
		if(Util.isEmpty(user.getU_password())) {
			throw new MyException("密码为空");
		}
		if(Util.isEmpty(user.getU_auth())) {
			throw new  MyException("身份为空 ");
		}
		transaction.begin();
		try {
			userBeanDao=(UserBeanDao) ObjectFactory.getInstance("UserBeanDao");
			userBeanDao.add(user);
		} catch (SQLException e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	/**
	 * 登录
	 */
	@Override
	public void login(UserBean user) throws MyException {
		
	}

	/**
	 * �û�ע��
	 */
	@Override
	public void delete(int index) throws MyException {
		try {
			userBeanDao=(UserBeanDao) ObjectFactory.getInstance("UserBeanDao");
			userBeanDao.delete(index);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��ѯ�����û�
	 */
	@Override
	public List<UserBean> queryUserAll() throws MyException {
		List<UserBean> userList=new ArrayList<UserBean>();
		try {
			userBeanDao=(UserBeanDao) ObjectFactory.getInstance("UserBeanDao");
			userList=userBeanDao.queryAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	/**
	 * ��ѯָ���û�
	 */
	@Override
	public UserBean queryUser(String userName) throws MyException {
		UserBean user=null;
		try {
			userBeanDao=(UserBeanDao) ObjectFactory.getInstance("UserBeanDao");
			user=userBeanDao.queryByName(userName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	
	
	public int changePassWord(UserBean user) throws MyException {
		int result = -1;
		if(Util.isEmpty(user.getU_name())) {
			throw new MyException("�û���Ϊ�գ��������û���");
		}
		try {
			if(null == userBeanDao.queryByName(user.getU_name())) {
				throw new MyException("�û�����ڣ�");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		transaction.begin();
		try {
			result =userBeanDao.modify(user);
			transaction.commit();
		} catch (SQLException e) {
			transaction.rollback();
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void modify(UserBean user) throws MyException {
//		UserBean user=null;
		if(Util.isEmpty(user.getU_name())) {
			throw new MyException("用户名为空");
		}
		if(Util.isEmpty(user.getU_password())) {
			throw new MyException("密码为空");
		}
		if(Util.isEmpty(user.getU_auth())) {
			throw new  MyException("身份为空 ");
		}
		userBeanDao=(UserBeanDao) ObjectFactory.getInstance("UserBeanDao");
		try {
			userBeanDao.modify(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
