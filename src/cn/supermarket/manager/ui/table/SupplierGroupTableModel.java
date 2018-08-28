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

public class SupplierGroupTableModel extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String[][] rowData={};
	private String[] columnNames={"供应商编号","供应商名称","总交易金额","商品种类","总商品数量"};

	private SupplierBeanService supplierService=(SupplierBeanService) ObjectFactory.getInstance("SupplierBeanService");
	private AccountBeanService accountService=(AccountBeanService) ObjectFactory.getInstance("AccountBeanService");

	public SupplierGroupTableModel(){

		try {
			List<SupplierBean> supplierList=supplierService.queryAll();
			List<AccountBean> accountList=accountService.queryAll();

			List<Integer> idList=new ArrayList<Integer>();
			List<String> nameList=new ArrayList<String>();
			List<AccountBean> newaccountList=new ArrayList<AccountBean>();

			List<Integer> newList=new ArrayList<Integer>();



			for(SupplierBean supplierBean:supplierList){
				if(!nameList.contains(supplierBean.getS_name())){
					nameList.add(supplierBean.getS_name());
					idList.add(supplierBean.getS_id());
				}
			}
			for(String name:nameList){
				AccountBean newaccountBean=new AccountBean();
				int num=0;
				double money=0;
				String supplierName=null;
				List<String> typeList=new ArrayList<String>();
				for(AccountBean accountBean:accountList){
					if((!typeList.contains(accountBean.getA_name())) && name.equals(accountBean.getS_name())){

						typeList.add(accountBean.getA_name());


					}
					if(name.equals(accountBean.getS_name())){
						num+=accountBean.getA_nums();
						money+=accountBean.getA_amount();
						supplierName=name;
					}


				}
				newaccountBean.setA_name(name);
				newaccountBean.setA_nums(num);
				newaccountBean.setS_name(supplierName);
				newaccountBean.setA_amount(money);
				newaccountList.add(newaccountBean);
				newList.add(typeList.size());
			}





			rowData=new String[nameList.size()][columnNames.length];
			for(int i=0;i<nameList.size();i++){
				rowData[i][0]=idList.get(i).toString();
				rowData[i][1]=nameList.get(i);
				rowData[i][2]=Double.toString(newaccountList.get(i).getA_amount());
				rowData[i][3]=newList.get(i).toString();
				rowData[i][4]=Integer.toString(newaccountList.get(i).getA_nums());




			}
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return rowData.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return rowData[rowIndex][columnIndex];
	}
	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}
}
