package cn.supermarket.manager.ui.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import cn.supermarket.manager.Service.AccountBeanService;
import cn.supermarket.manager.entity.AccountBean;
import cn.supermarket.manager.exception.MyException;
import cn.supermarket.manager.object.ObjectFactory;

public class AccountTableModel2 extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private AccountBeanService accountService=(AccountBeanService) ObjectFactory.getInstance("AccountBeanService");

	private String[][] rowData=null;
	private String[] columnNames= {"账单编号","商品名称","商品数量","交易金额","是否付款","供应商名称","商品描述","账单时间"};	



	public AccountTableModel2(){

		try {
			List<AccountBean> accountList=accountService.queryAll();
			rowData=new String[accountList.size()][columnNames.length];
			for(int i=0;i<accountList.size();i++){
				rowData[i][0]=Integer.toString(accountList.get(i).getA_id());
				rowData[i][1]=accountList.get(i).getA_name();
				rowData[i][2]=Integer.toString(accountList.get(i).getA_nums());
				rowData[i][3]=Double.toString(accountList.get(i).getA_amount());
				rowData[i][4]=Integer.toString(accountList.get(i).getA_ispayed());
				rowData[i][5]=accountList.get(i).getS_name();
				rowData[i][6]=accountList.get(i).getA_Info();
				rowData[i][7]=accountList.get(i).getA_Date().toString();
				
				
				
				
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
