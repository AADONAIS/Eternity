package cn.supermarket.manager.Service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.supermarket.manager.Dao.AccountBeanDao;
import cn.supermarket.manager.Service.AccountBeanService;
import cn.supermarket.manager.entity.AccountBean;
import cn.supermarket.manager.exception.MyException;
import cn.supermarket.manager.object.ObjectFactory;
import cn.supermarket.manager.util.Util;

public class AccountBeanServiceImpl implements AccountBeanService {

	private AccountBeanDao accountDao=(AccountBeanDao) ObjectFactory.getInstance("AccountBeanDao");
	@Override
	public List<AccountBean> queryByNameAndIspay(int ispay,String name) throws MyException {
		List<AccountBean> accountList=new ArrayList<AccountBean>();
		
		accountDao=(AccountBeanDao) ObjectFactory.getInstance("AccountBeanDao");
		try {
			accountList=accountDao.queryByNameandispay(ispay, name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return accountList;
	}
	@Override
	public List<AccountBean> queryAll() throws MyException {
		List<AccountBean> accountList=new ArrayList<AccountBean>();
		
		try {
			accountDao=(AccountBeanDao) ObjectFactory.getInstance("AccountBeanDao");
			accountList=accountDao.queryAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountList;
	}
	@Override
	public void add(AccountBean accountBean) throws MyException {
		accountDao=(AccountBeanDao) ObjectFactory.getInstance("AccountBeanDao");
		if(Util.isEmpty(accountBean.getA_name())){
			throw new MyException("商品名称为空");
		}
		if(Util.isEmpty(Integer.toString(accountBean.getA_nums()))){
			throw new MyException("交易数量为空");
		}
		if(Util.isEmpty(accountBean.getA_unit())){
			throw new MyException("交易单位为空");
		}
		if(Util.isEmpty(Double.toString(accountBean.getA_amount()))){
			throw new MyException("交易金额为空");
		}
		if(Util.isEmpty(Integer.toString(accountBean.getA_ispayed()))){
			throw new MyException("未选择是否付款");
		}
		if(Util.isEmpty(accountBean.getA_Date().toString())){
			throw new MyException("交易时间为空");
		}
		try {
			accountDao.add(accountBean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void modify(int index,AccountBean accountBean) throws MyException {
		if(Util.isEmpty(accountBean.getA_name())){
			throw new MyException("商品名称为空");
		}
		if(Util.isEmpty(Integer.toString(accountBean.getA_nums()))){
			throw new MyException("交易数量为空");
		}
		if(Util.isEmpty(accountBean.getA_unit())){
			throw new MyException("交易单位为空");
		}
		if(Util.isEmpty(Double.toString(accountBean.getA_amount()))){
			throw new MyException("交易金额为空");
		}
		if(Util.isEmpty(Integer.toString(accountBean.getA_ispayed()))){
			throw new MyException("未选择是否付款");
		}
		if(Util.isEmpty(accountBean.getA_Date().toString())){
			throw new MyException("交易时间为空");
		}
		accountDao=(AccountBeanDao) ObjectFactory.getInstance("AccountBeanDao");
		try {
			accountDao.modify(index,accountBean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void delete(int index, AccountBean accountBean) throws MyException {
		try {
			accountDao=(AccountBeanDao) ObjectFactory.getInstance("AccountBeanDao");
			accountDao.delete(index, accountBean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
