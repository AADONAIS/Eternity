package cn.supermarket.manager.Service;

import java.util.List;

import cn.supermarket.manager.entity.AccountBean;
import cn.supermarket.manager.exception.MyException;

public interface AccountBeanService {

	public abstract List<AccountBean> queryByNameAndIspay(int ispay,String name)throws MyException;
	
	public abstract List<AccountBean> queryAll()throws MyException;
	
	public abstract void add(AccountBean accountBean) throws MyException;
	
	public abstract void modify(int index,AccountBean accountBean) throws MyException;
	
	public abstract void delete(int index,AccountBean accountBean)throws MyException;
}
