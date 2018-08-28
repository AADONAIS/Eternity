package cn.supermarket.manager.Service;

import java.util.List;

import cn.supermarket.manager.entity.SupplierBean;
import cn.supermarket.manager.entity.UserBean;
import cn.supermarket.manager.exception.MyException;

public interface SupplierBeanService {

	public abstract SupplierBean querySupplier(String supplierName)throws MyException;
	
	public abstract List<SupplierBean> queryAll()throws MyException;
	
	public abstract void add(SupplierBean supplierBean) throws MyException;
	
	public abstract void modify(SupplierBean supplierBean)throws MyException;
	
	public abstract void delete(int index,SupplierBean supplierBean)throws MyException;
	
}
