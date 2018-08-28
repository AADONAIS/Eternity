package cn.supermarket.manager.ui.table;


import javax.swing.table.AbstractTableModel;

import cn.supermarket.manager.Service.SupplierBeanService;
import cn.supermarket.manager.entity.SupplierBean;
import cn.supermarket.manager.exception.MyException;
import cn.supermarket.manager.object.ObjectFactory;
public class SupplierTableModel extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String[][] rowData= null;
	private String[] columnNames= {"编号","供应商名称","供应商描述","联系人","电话","地址","传真"};
	
	private SupplierBeanService supplierBeanService=(SupplierBeanService) ObjectFactory.getInstance("SupplierBeanService");
	public SupplierTableModel(String name){
		try {
			SupplierBean supplierBean=(SupplierBean) supplierBeanService.querySupplier(name);
			rowData=new String[1][columnNames.length];
				rowData[0][0]=Integer.toString(supplierBean.getS_id());
				rowData[0][1]=supplierBean.getS_name();
				rowData[0][2]=supplierBean.getS_info();
				rowData[0][3]=supplierBean.getS_linkman();
				rowData[0][4]=supplierBean.getS_phone();
				rowData[0][5]=supplierBean.getS_address();
				rowData[0][6]=supplierBean.getS_faxes();
				
			
			
			
			
		} catch (MyException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return 1;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return rowData[0][columnIndex];
	}
	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}
}
