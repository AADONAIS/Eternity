package cn.supermarket.manager.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.JobAttributes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

import cn.supermarket.manager.Service.AccountBeanService;
import cn.supermarket.manager.entity.AccountBean;
import cn.supermarket.manager.entity.UserBean;
import cn.supermarket.manager.exception.MyException;
import cn.supermarket.manager.object.ObjectFactory;
import cn.supermarket.manager.ui.table.AccountTableModel;
import cn.supermarket.manager.ui.table.AccountTableModel2;
import cn.supermarket.manager.util.Util;

public class AccountManagerUI extends JFrame implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Image image;
	private ImageIcon icon;

	private JLabel hello=new JLabel("您好:");
	private JLabel usernameLabel=new JLabel();
	private UserBean user=new UserBean();
	private JLabel timeLabel=new JLabel(user.getU_name());


	String [] rboxarray= {"请选择:","是","否"};
	private JLabel itemName=new JLabel("商品名称:");
	private JTextField itemFiled=new JTextField(20);
	private JLabel chooseLabel=new JLabel("是否付款:");
	private JComboBox<String> rbox=new JComboBox<String>(rboxarray);
	private JButton queryButton=new JButton("组合查询");

	private String[][] rowData= {};
	private String[] columnNames= {"账单编号","商品名称","商品数量","交易金额","是否付款","供应商名称","商品描述","账单时间"};

	private JButton exportButton=new JButton("导出");
	private JButton addButton=new JButton("添加数据");
	private JButton updateButton=new JButton("修改数据");
	private JButton deleteButton=new JButton("删除数据");

	private JLabel titleLabel=new JLabel("账单管理>>");

	private JTable accountTable=new JTable(rowData,columnNames);
	private JScrollPane jsPane = new JScrollPane(accountTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	private AccountBean accountBean=new AccountBean();
	private AccountBeanService accountService=(AccountBeanService) ObjectFactory.getInstance("AccountBeanService");

	public AccountManagerUI(final UserBean user){

		this.setTitle("账单管理界面");
		this.setSize(1000, 800);
		this.setVisible(true);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		JPanel contentPanel=new JPanel(){
			private static final long serialVersionUID = 1L;
			@Override
			public void paint(Graphics g) {
				icon=new ImageIcon("./img/MainFrame.png");
				image=icon.getImage();
				g.drawImage(image, 0,0,null);

			}
		};

		JPanel accountManagerPanel=new JPanel(){
			private static final long serialVersionUID = 1L;
			@Override
			public void paint(Graphics g) {
				icon=new ImageIcon("./img/btn_bill.gif");
				image=icon.getImage();
				g.drawImage(image, 0,0,null);

			}
		};
		JPanel supplierManagerPanel=new JPanel(){
			private static final long serialVersionUID = 1L;
			@Override
			public void paint(Graphics g) {
				icon=new ImageIcon("./img/btn_suppliers.gif");
				image=icon.getImage();
				g.drawImage(image, 0,0,null);

			}
		};
		JPanel userManagerPanel=new JPanel(){
			private static final long serialVersionUID = 1L;
			@Override
			public void paint(Graphics g) {
				icon=new ImageIcon("./img/btn_users.gif");
				image=icon.getImage();
				g.drawImage(image, 0,0,null);

			}
		};
		JPanel reportsManagerPanel=new JPanel(){
			private static final long serialVersionUID = 1L;
			@Override
			public void paint(Graphics g) {
				icon=new ImageIcon("./img/btn_reports.gif");
				image=icon.getImage();
				g.drawImage(image, 0,0,null);

			}
		};
		JPanel exitPanel=new JPanel(){
			private static final long serialVersionUID = 1L;
			@Override
			public void paint(Graphics g) {
				icon=new ImageIcon("./img/btn_exit.gif");
				image=icon.getImage();
				g.drawImage(image, 0,0,null);

			}
		};
		accountManagerPanel.setBounds(10, 115, 170, 90);
		supplierManagerPanel.setBounds(10, 170, 170, 95);
		userManagerPanel.setBounds(10, 225, 170, 90);
		reportsManagerPanel.setBounds(10, 280,170, 90);
		exitPanel.setBounds(10, 335,170, 90);
		contentPanel.setBounds(0, 0, 1000, 800);
		hello.setBounds(500, 40, 100, 40);
		hello.setFont(new Font("楷体", Font.BOLD, 15));
		usernameLabel.setBounds(580, 40, 100, 60);
		usernameLabel.setFont(new Font("楷体", Font.ITALIC, 20));
		usernameLabel.setBackground(Color.GREEN);
		timeLabel.setBounds(700, 70, 130, 50);
		timeLabel.setBackground(Color.ORANGE);

		itemName.setBounds(220, 150, 80, 30);
		itemFiled.setBounds(290, 155, 120, 20);
		chooseLabel.setBounds(440, 150, 80, 30);
		rbox.setBounds(500, 155, 80, 25);
		queryButton.setBounds(690, 150, 100, 27);
		queryButton.setBackground(Color.ORANGE);

		titleLabel.setBounds(220, 230, 150, 30);
		titleLabel.setFont(new Font("楷体", Font.BOLD+Font.ITALIC, 25));

		exportButton.setBounds(390, 234, 70, 25);
		exportButton.setBackground(Color.YELLOW);
		addButton.setBounds(520, 234, 90, 25);
		addButton.setBackground(Color.PINK);
		updateButton.setBounds(640, 234, 90, 25);
		updateButton.setBackground(Color.PINK);
		deleteButton.setBounds(760, 234, 90, 25);
		deleteButton.setBackground(Color.PINK);

		jsPane.setBounds(250, 280, 600, 250);

		this.add(jsPane);
		this.add(deleteButton);
		this.add(updateButton);
		this.add(addButton);
		this.add(exportButton);
		this.add(titleLabel);
		this.add(queryButton);
		this.add(rbox);
		this.add(chooseLabel);
		this.add(itemFiled);
		this.add(itemName);
		this.add(timeLabel);
		this.add(usernameLabel);
		this.add(hello);
		this.add(exitPanel);
		this.add(reportsManagerPanel);
		this.add(userManagerPanel);
		this.add(supplierManagerPanel);
		this.add(accountManagerPanel);
		this.add(contentPanel);
		new Thread(this).start();

		accountManagerPanel.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});

		supplierManagerPanel.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				AccountManagerUI.this.setVisible(false);
				new SupplierManagerUI(user);
			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});

		userManagerPanel.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				AccountManagerUI.this.setVisible(false);
				new UserManagerUI();
			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});

		reportsManagerPanel.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				AccountManagerUI.this.setVisible(false);
				new ReportManagerUI();

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});






		//退出框添加监听事件
		exitPanel.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				int result=JOptionPane.showConfirmDialog(new JFrame(),"是否退出?","退出提示",JOptionPane.YES_NO_OPTION);
				if(result==0) {
					AccountManagerUI.this.setVisible(false);
					new MainUI(user);
				}else {

				}
			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});

		//导出按钮添加监听事件 
		exportButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser filechooser=new JFileChooser("/home/soft02/桌面/0816-/test");
				filechooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				int returnVal=filechooser.showSaveDialog(filechooser);
				if(returnVal==JFileChooser.APPROVE_OPTION){
					//					File file=filechooser.getSelectedFile();
					String filepath=filechooser.getSelectedFile().getAbsolutePath();
					TableModel accountmodel=accountTable.getModel();
					try {
						BufferedWriter bWriter=new BufferedWriter(new FileWriter(filepath));
						for(int i=0;i<accountmodel.getColumnCount();i++){
							bWriter.write(accountmodel.getColumnName(i));
							bWriter.write("\t");
						}
						bWriter.newLine();
						for(int i=0;i<accountmodel.getRowCount();i++){
							for(int j=0;j<accountmodel.getColumnCount();j++){
								bWriter.write(accountmodel.getValueAt(i, j).toString());
								bWriter.write("\t");
							}
							bWriter.newLine();
						}
						bWriter.close();
						JOptionPane.showMessageDialog(new JFrame(), "导出成功!");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}



			}
		});
		/**
		 * 添加数据添加监听事件
		 */
		addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AccountManagerUI.this.setVisible(false);
				new AddItemUI();
			}
		});
		/**
		 * 修改数据按钮添加监听事件
		 */
		updateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AccountManagerUI.this.setVisible(false);
				int index=Integer.valueOf((String) accountTable.getValueAt(accountTable.getSelectedRow(), 0));
				String name=(String) accountTable.getValueAt(accountTable.getSelectedRow(), 1);
				String nums=(String) accountTable.getValueAt(accountTable.getSelectedRow(), 2);
				String money=(String) accountTable.getValueAt(accountTable.getSelectedRow(), 3);
				String supplierName=(String) accountTable.getValueAt(accountTable.getSelectedRow(), 5);
				String accountInfo=(String) accountTable.getValueAt(accountTable.getSelectedRow(), 6);
				String time=(String) accountTable.getValueAt(accountTable.getSelectedRow(), 7);
				new ModifyItemUI(index,name,nums,money,supplierName,accountInfo,time);
			}
		});

		/**
		 * 删除数据按钮添加监听事件
		 */
		deleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int index=Integer.valueOf((String) accountTable.getValueAt(accountTable.getSelectedRow(), 0));
				try {
					accountService.delete(index, accountBean);
					JOptionPane.showMessageDialog(new JFrame(), "删除成功!");
				} catch (MyException e1) {
					e1.printStackTrace();
				}
			}
		});
		/**
		 * 组合查询按钮添加监听事件
		 */
		queryButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//1代表已经付款  0代表未付款

				String name=itemFiled.getText();
				if(Util.isEmpty(itemFiled.getText())){
					accountTable.setModel(new AccountTableModel2());
				}else if(rbox.getSelectedItem().equals(rbox.getItemAt(1))){
					accountTable.setModel(new AccountTableModel(1, name));
				}else if(rbox.getSelectedItem().equals(rbox.getItemAt(2))){
					accountTable.setModel(new AccountTableModel(0, name));	
				}
			}
		});
	}

	@Override
	public void run() {
		while(true){
			SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd HH:mm:ss");
			try {
				String text=sdf.format(System.currentTimeMillis());
				timeLabel.setText(text);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		
	}
}
