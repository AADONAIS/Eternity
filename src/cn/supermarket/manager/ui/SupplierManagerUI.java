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


import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import cn.supermarket.manager.Service.SupplierBeanService;
import cn.supermarket.manager.entity.SupplierBean;
import cn.supermarket.manager.entity.UserBean;
import cn.supermarket.manager.exception.MyException;
import cn.supermarket.manager.object.ObjectFactory;
import cn.supermarket.manager.ui.table.NewInportSupplier;
import cn.supermarket.manager.ui.table.SupplierTableModel;
import cn.supermarket.manager.ui.table.SupplierTableModel2;
import cn.supermarket.manager.util.Util;
public class SupplierManagerUI extends JFrame implements Runnable{

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


	private JLabel supplierName=new JLabel("供应商名称:");
	private JTextField itemFiled=new JTextField(20);
	private JButton queryButton=new JButton("查询");

	private String[][] rowData= {};
	private String[] columnNames= {"供应商名称","供应商描述","联系人","电话","地址","供应商传真"};
	//供应商编号,供应商名称,供应商描述,供应商联系人,供应商电话,供应商地址,供应商传真
	private JButton inputButton=new JButton("导入");
	private JButton addButton=new JButton("添加数据");
	private JButton updateButton=new JButton("修改数据");
	private JButton deleteButton=new JButton("删除数据");

	private JLabel titleLabel=new JLabel("供应商管理>>");

	private JTable supplierTable=new JTable(rowData,columnNames);
	private JScrollPane jsPane = new JScrollPane(supplierTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	private SupplierBean supplierBean=new SupplierBean();
	private SupplierBeanService supplierService=(SupplierBeanService) ObjectFactory.getInstance("SupplierBeanService");

	//	private List<String> supplierlist=new ArrayList<String>(); 

	public SupplierManagerUI(final UserBean user){
		this.setTitle("供应商管理界面");
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

		usernameLabel.setText(user.getU_name());

		supplierName.setBounds(220, 150, 80, 30);
		itemFiled.setBounds(290, 155, 120, 20);
		queryButton.setBounds(450, 150, 100, 27);
		queryButton.setBackground(Color.ORANGE);

		titleLabel.setBounds(220, 230, 180, 30);
		titleLabel.setFont(new Font("楷体", Font.BOLD+Font.ITALIC, 25));

		inputButton.setBounds(400, 234, 70, 25);
		inputButton.setBackground(Color.YELLOW);
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
		this.add(inputButton);
		this.add(titleLabel);
		this.add(queryButton);
		this.add(itemFiled);
		this.add(supplierName);
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
				SupplierManagerUI.this.setVisible(false);
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
				SupplierManagerUI.this.setVisible(false);
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
				SupplierManagerUI.this.setVisible(false);
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
					SupplierManagerUI.this.setVisible(false);
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
		 * 导入按钮添加监听事件
		 */
		inputButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				supplierTable.setModel(new NewInportSupplier());
				supplierTable.setModel(new SupplierTableModel2());
			}
		});
		/**
		 * 添加数据按钮添加监听事件
		 */
		addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SupplierManagerUI.this.setVisible(false);
				new AddSupplierUI(user);
			}
		});
		/**
		 * 修改数据按钮添加监听事件
		 */
		updateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SupplierManagerUI.this.setVisible(false);
				int index=Integer.valueOf((String) supplierTable.getValueAt(supplierTable.getSelectedRow(), 0));
				String name=(String) supplierTable.getValueAt(supplierTable.getSelectedRow(), 1);
				String info=(String)supplierTable.getValueAt(supplierTable.getSelectedRow(),2);
				String linkman=(String) supplierTable.getValueAt(supplierTable.getSelectedRow(), 3);
				String phone=(String) supplierTable.getValueAt(supplierTable.getSelectedRow(), 4);
				String address=(String) supplierTable.getValueAt(supplierTable.getSelectedRow(), 5);
				String fax=(String) supplierTable.getValueAt(supplierTable.getSelectedRow(), 6);
				new ModifySupplierUI(index,name,info,linkman,phone,address,fax);
			}
		});

		/**
		 * 删除数据按钮添加监听事件
		 */
		deleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int index=Integer.valueOf((String) supplierTable.getValueAt(supplierTable.getSelectedRow(), 0));
				try {
					supplierService.delete(index, supplierBean);
					JOptionPane.showMessageDialog(new JFrame(), "删除成功!");
					supplierTable.setModel(new SupplierTableModel2());
				} catch (MyException e1) {
					e1.printStackTrace();
				}
			}
		});
		/**
		 * 查询按钮添加监听事件
		 */
		queryButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(Util.isEmpty(itemFiled.getText())){
					supplierTable.setModel(new SupplierTableModel2());
				}else if(!Util.isEmpty(itemFiled.getText())){
					supplierTable.setModel(new SupplierTableModel(itemFiled.getText()));
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
