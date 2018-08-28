package cn.supermarket.manager.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import cn.supermarket.manager.Service.UserBeanService;
import cn.supermarket.manager.entity.UserBean;
import cn.supermarket.manager.exception.MyException;
import cn.supermarket.manager.object.ObjectFactory;
import cn.supermarket.manager.ui.table.UserTableModel;
import cn.supermarket.manager.ui.table.UserTableModel2;
public class UserManagerUI extends JFrame implements Runnable{

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


	private JLabel itemName=new JLabel("用户名称:");
	private JTextField itemFiled=new JTextField(20);
	private JButton queryButton=new JButton("查询");

	private String[][] rowData= {};
	private String[] columnNames= {"编号","姓名","性别","年龄","电话","地址","权限"};
	/*编号,姓名,密码,性别,年龄,电话号码,地址,权限*/
	private JButton addButton=new JButton("添加数据");
	private JButton updateButton=new JButton("修改数据");
	private JButton deleteButton=new JButton("删除数据");

	private JLabel titleLabel=new JLabel("用户管理>>");

	private JTable userTable=new JTable(rowData,columnNames);
	private JScrollPane jsPane = new JScrollPane(userTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	private UserBeanService userService=(UserBeanService) ObjectFactory.getInstance("UserBeanService");

	public UserManagerUI(){
		this.setTitle("用户管理界面");
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
		queryButton.setBounds(450, 150, 100, 27);
		queryButton.setBackground(Color.ORANGE);

		titleLabel.setBounds(220, 230, 180, 30);
		titleLabel.setFont(new Font("楷体", Font.BOLD+Font.ITALIC, 25));

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
		this.add(titleLabel);
		this.add(queryButton);
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
				UserManagerUI.this.setVisible(false);
				new AccountManagerUI(user);
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
				UserManagerUI.this.setVisible(false);
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
				UserManagerUI.this.setVisible(false);
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
					UserManagerUI.this.setVisible(false);
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

		/**
		 * 添加数据按钮添加监听事件
		 */
		addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				UserManagerUI.this.setVisible(false);
				new AddUserUI();
			}
		});
		/**
		 * 修改用户按钮事件
		 */
		updateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row[]=userTable.getSelectedRows();
				if(row.length==0){
					JOptionPane.showMessageDialog(new JFrame(), "未选中行");
				}else if(row.length==1){
					UserManagerUI.this.setVisible(false);
					int index=Integer.valueOf((String) userTable.getValueAt(userTable.getSelectedRow(), 0));
					String name=(String)userTable.getValueAt(userTable.getSelectedRow(), 1);
		            String sex=(String)userTable.getValueAt(userTable.getSelectedRow(), 2);
		            String age=(String)userTable.getValueAt(userTable.getSelectedRow(), 3);
		            String phone=(String)userTable.getValueAt(userTable.getSelectedRow(), 4);
					String address=(String)userTable.getValueAt(userTable.getSelectedRow(), 5);
					String password=null;
					try {
						UserBean user=userService.queryUser(name);
						password=user.getU_password();
					} catch (MyException e1) {
						e1.printStackTrace();
					}
		            new ModifyUserUI(index,name,password,sex,age,phone,address);
				}else if(row.length>1){
					JOptionPane.showMessageDialog(new JFrame(), "不能删除多行数据");
				}
			}
		});
		/**
		 * 删除数据按钮添加监听事件
		 */
		deleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row[]=userTable.getSelectedRows();
				if(row.length==0){
					JOptionPane.showMessageDialog(new JFrame(), "未选中行");
				}else{
					try {
						for(int i=0;i<row.length;i++){
							int dindex=Integer.valueOf((String) userTable.getValueAt(row[i], 0));
							if(userTable.getValueAt(row[i], 6).equals("普通员工")){
							userService.delete(dindex);
							JOptionPane.showMessageDialog(new JFrame(), "删除成功!");
							}else if(userTable.getValueAt(row[i], 6).equals("管理员")){
								JOptionPane.showMessageDialog(new JFrame(), "请联系超级赛亚人");
							}
						}
					} catch (MyException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		queryButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(null==itemFiled.getText() || "".equals(itemFiled.getText())){
					userTable.setModel(new UserTableModel2());
				}else{
					List<UserBean> userList=new ArrayList<UserBean>();
					try {
						userList=userService.queryUserAll();
						for(int i=0;i<userList.size();i++){
							if(!itemFiled.getText().equals(userList.get(i).getU_name())){

								JOptionPane.showMessageDialog(new JFrame(), "此用户不存在");
								break;
							}
							if(itemFiled.getText().equals(userList.get(i).getU_name())){

								userTable.setModel(new UserTableModel(itemFiled.getText()));
							}
						}
					} catch (MyException e1) {
						e1.printStackTrace();
					}

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
