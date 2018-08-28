package cn.supermarket.manager.ui.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import cn.supermarket.manager.Service.UserBeanService;
import cn.supermarket.manager.entity.UserBean;
import cn.supermarket.manager.exception.MyException;
import cn.supermarket.manager.object.ObjectFactory;

public class UserTableModel2 extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String[][] rowData=null;
	private String[] columnNames= {"编号","姓名","性别","年龄","电话","地址","权限"};

	private UserBeanService userService=(UserBeanService) ObjectFactory.getInstance("UserBeanService");

	public UserTableModel2(){
		List<UserBean> userList;
		try {
			userList = userService.queryUserAll();
			rowData=new String[userList.size()][columnNames.length];
			for(int i=0;i<userList.size();i++){
				rowData[i][0]=Integer.toString(userList.get(i).getU_id());
				rowData[i][1]=userList.get(i).getU_name();
				rowData[i][2]=userList.get(i).getU_gender();
				rowData[i][3]=Integer.toString(userList.get(i).getU_age());
				rowData[i][4]=userList.get(i).getU_phone();
				rowData[i][5]=userList.get(i).getU_address();
				rowData[i][6]=userList.get(i).getU_auth();
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
