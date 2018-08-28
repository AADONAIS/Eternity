package cn.supermarket.manager.ui.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import cn.supermarket.manager.Service.SupplierBeanService;
import cn.supermarket.manager.entity.SupplierBean;
import cn.supermarket.manager.exception.MyException;
import cn.supermarket.manager.object.ObjectFactory;

public class SupplierTableModel2 extends AbstractTableModel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String[][] rowData= null;
	private String[] columnNames= {"编号","供应商名称","供应商描述","联系人","电话","地址","传真"};
	
	private SupplierBeanService supplierBeanService=(SupplierBeanService) ObjectFactory.getInstance("SupplierBeanService");
	
	
	
	public SupplierTableModel2(){
		try {
			List<SupplierBean> supplierList=supplierBeanService.queryAll();
			rowData=new String[supplierList.size()][columnNames.length];
			for(int i=0;i<supplierList.size();i++){
				rowData[i][0]=Integer.toString(supplierList.get(i).getS_id());			
				rowData[i][1]=supplierList.get(i).getS_name();
				rowData[i][2]=supplierList.get(i).getS_info();
				rowData[i][3]=supplierList.get(i).getS_linkman();
				rowData[i][4]=supplierList.get(i).getS_phone();
				rowData[i][5]=supplierList.get(i).getS_address();
				rowData[i][6]=supplierList.get(i).getS_faxes();			
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
