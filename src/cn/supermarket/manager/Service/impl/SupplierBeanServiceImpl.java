package cn.supermarket.manager.Service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.supermarket.manager.Dao.SupplierBeanDao;
import cn.supermarket.manager.Service.SupplierBeanService;
import cn.supermarket.manager.entity.SupplierBean;
import cn.supermarket.manager.exception.MyException;
import cn.supermarket.manager.object.ObjectFactory;
import cn.supermarket.manager.util.Util;

public class SupplierBeanServiceImpl  implements SupplierBeanService{

	private SupplierBeanDao supplierDao=(SupplierBeanDao) ObjectFactory.getInstance("SupplierBeanDao");

	@Override
	public SupplierBean querySupplier(String supplierName) throws MyException {
		SupplierBean supplierBean=null;
		try {
			supplierDao=(SupplierBeanDao) ObjectFactory.getInstance("SupplierBeanDao");
			supplierBean=supplierDao.queryByName(supplierName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return supplierBean;
	}

	@Override
	public List<SupplierBean> queryAll() throws MyException {
		List<SupplierBean> supplierList=new ArrayList<SupplierBean>();
		supplierDao=(SupplierBeanDao) ObjectFactory.getInstance("SupplierBeanDao");
		try {
			supplierList=supplierDao.queryAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return supplierList;
	}

	@Override
	public void add(SupplierBean supplierBean) throws MyException {
		if(Util.isEmpty(supplierBean.getS_name())){
			throw new MyException("供应商名称为空");
		}
		if(Util.isEmpty(supplierBean.getS_linkman())){
			throw new MyException("供应商联系人为空");
		}
		if(Util.isEmpty(supplierBean.getS_phone())){
			throw new MyException("供应商电话为空");
		}
		if(Util.isEmpty(supplierBean.getS_address())){
			throw new MyException("供应商地址为空");
		}
		try {
			supplierDao=(SupplierBeanDao) ObjectFactory.getInstance("SupplierBeanDao");
			supplierDao.add(supplierBean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modify(SupplierBean supplierBean) throws MyException {
		if(Util.isEmpty(supplierBean.getS_name())){
			throw new MyException("供应商名称为空");
		}
		if(Util.isEmpty(supplierBean.getS_linkman())){
			throw new MyException("供应商联系人为空");
		}
		if(Util.isEmpty(supplierBean.getS_phone())){
			throw new MyException("供应商电话为空");
		}
		if(Util.isEmpty(supplierBean.getS_address())){
			throw new MyException("供应商地址为空");
		}
		supplierDao=(SupplierBeanDao) ObjectFactory.getInstance("SupplierBeanDao");
		try {
			supplierDao.modify(supplierBean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int index, SupplierBean supplierBean) throws MyException {
		try {
			supplierDao=(SupplierBeanDao) ObjectFactory.getInstance("SupplierBeanDao");
			supplierDao.delete(index, supplierBean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
