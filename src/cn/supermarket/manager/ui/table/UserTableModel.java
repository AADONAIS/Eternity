package cn.supermarket.manager.ui.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import cn.supermarket.manager.Service.UserBeanService;
import cn.supermarket.manager.entity.UserBean;
import cn.supermarket.manager.exception.MyException;
import cn.supermarket.manager.object.ObjectFactory;

public class UserTableModel extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String[][] rowData=null;
	private String[] columnNames= {"编号","姓名","性别","年龄","电话","地址","权限"};

	private UserBeanService userService=(UserBeanService) ObjectFactory.getInstance("UserBeanService");
	public UserTableModel(String name){

		if(name!=null){
			try {
				UserBean user=userService.queryUser(name);
				if(user!=null){
					rowData=new String[1][columnNames.length];
					rowData[0][0]=Integer.toString(user.getU_id());
					rowData[0][1]=user.getU_name();
					rowData[0][2]=user.getU_gender();
					rowData[0][3]=Integer.toString(user.getU_age());
					rowData[0][4]=user.getU_phone();
					rowData[0][5]=user.getU_address();
					rowData[0][6]=user.getU_auth();
				}
			} catch (MyException e) {
				e.printStackTrace();
			}
		}else if(name==null){
			try {
				List<UserBean> userList=userService.queryUserAll();
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
