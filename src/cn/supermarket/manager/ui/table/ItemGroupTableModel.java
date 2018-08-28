package cn.supermarket.manager.ui.table;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import cn.supermarket.manager.Service.AccountBeanService;
import cn.supermarket.manager.Service.SupplierBeanService;
import cn.supermarket.manager.entity.AccountBean;
import cn.supermarket.manager.entity.SupplierBean;
import cn.supermarket.manager.exception.MyException;
import cn.supermarket.manager.object.ObjectFactory;

public class ItemGroupTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String[][] rowData={};
	private String[] columnNames={"商品名称","交易数量","交易金额","供应商名称"};
	
//	private SupplierBeanService supplierService=(SupplierBeanService) ObjectFactory.getInstance("SupplierBeanService");
	private AccountBeanService accountService=(AccountBeanService) ObjectFactory.getInstance("AccountBeanService");
	
	public ItemGroupTableModel(){
		try {
//			List<SupplierBean> supplierList=supplierService.queryAll();
			List<AccountBean> accountList=accountService.queryAll();
			
			List<String> nameList=new ArrayList<String>();
			for (AccountBean accountBean : accountList) {
				if(!nameList.contains(accountBean.getA_name())){
					nameList.add(accountBean.getA_name());
				}
			}
			
			List<AccountBean> otherList=new ArrayList<AccountBean>();
			for(String name:nameList){
				AccountBean NewaccountBean=new AccountBean();
				int num=0;
				double money=0;
				String suppliername=null;
				for (AccountBean accountBean : accountList) {
					if(name.equals(accountBean.getA_name())){
						num+=accountBean.getA_nums();
						money+=accountBean.getA_amount();
						suppliername=accountBean.getS_name();
					}
				}
				NewaccountBean.setA_name(name);
				NewaccountBean.setS_name(suppliername);
				NewaccountBean.setA_amount(money);
				NewaccountBean.setA_nums(num);
				otherList.add(NewaccountBean);
				
				
			}
			
			rowData=new String[otherList.size()][columnNames.length];
			for(int i=0;i<otherList.size();i++){
				rowData[i][0]=otherList.get(i).getA_name();
				rowData[i][1]=Integer.toString(otherList.get(i).getA_nums());
				rowData[i][2]=Double.toString(otherList.get(i).getA_amount());
				rowData[i][3]=otherList.get(i).getS_name();		
			}
		} catch (MyException e) {
			e.printStackTrace();
		} 
		
		
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return rowData.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return rowData[rowIndex][columnIndex];
	}
	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}
}
