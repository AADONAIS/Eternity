package cn.supermarket.manager.ui.table;

import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import cn.supermarket.manager.Service.SupplierBeanService;
import cn.supermarket.manager.entity.SupplierBean;
import cn.supermarket.manager.exception.MyException;
import cn.supermarket.manager.object.ObjectFactory;
public class NewInportSupplier  extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String[][] rowData=null;
	private String[] columnNames= {"供应商名称","供应商描述","联系人","电话","地址","传真"};

	private SupplierBeanService supplierService=(SupplierBeanService) ObjectFactory.getInstance("SupplierBeanService");

	public NewInportSupplier(){
		SupplierBean supplierBean=new SupplierBean();
		JFileChooser filechooser=new JFileChooser("/home/soft02/桌面/0816-/test/1");
		filechooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int returnVal=filechooser.showOpenDialog(new JFrame());
		if(returnVal==JFileChooser.APPROVE_OPTION){
			String filepath=filechooser.getSelectedFile().getAbsolutePath();
			try {
				FileReader fs=new FileReader(filepath);
				FileReader fs2=new FileReader(filepath);
				BufferedReader br=new BufferedReader(fs);
				BufferedReader br2=new BufferedReader(fs2);
				int maxColumnNumber=0; //保存最大列数
				int maxLineNumber=100;  //保存行数


				String line=null;
				int row=0;
				int sign=-1;
				while(null!=(line=br2.readLine())){

					sign++;

				}
				rowData=new String[sign][7];
				line=null;
				while(null!=(line=br.readLine())){
					String[]str=line.split("\\|");
					if(maxColumnNumber<str.length){
						maxColumnNumber=str.length;
					}
					for(int i=0;i<maxLineNumber;i++){
						for(int j=0;j<str.length-1;j++){
							rowData[row][j]=str[j+1];
						}
					}
					supplierBean.setS_name(rowData[row][0]);
					supplierBean.setS_info(rowData[row][1]);
					supplierBean.setS_linkman(rowData[row][2]);
					supplierBean.setS_phone(rowData[row][3]);
					supplierBean.setS_address(rowData[row][4]);
					supplierBean.setS_faxes(rowData[row][5]);
				}
				try {
					supplierService=(SupplierBeanService) ObjectFactory.getInstance("SupplierBeanService");

					supplierService.add(supplierBean);
					JOptionPane.showMessageDialog(new JFrame(), "导入成功!");

				} catch (MyException e) {
					e.printStackTrace();
				}

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}






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
