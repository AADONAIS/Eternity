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

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import cn.supermarket.manager.entity.UserBean;
import cn.supermarket.manager.ui.table.ItemGroupTableModel;
import cn.supermarket.manager.ui.table.SupplierGroupTableModel;

public class ReportManagerUI extends JFrame implements Runnable {

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

	//供应商分组查询
	private String[][] rowData1= {};
	private String[] columnNames1= {"供应商编号","供应商名称","总交易金额","商品种类","总商品数量"};
	private JTable supplierGroupTable=new JTable(rowData1,columnNames1);
	private JScrollPane jsPane = new JScrollPane(supplierGroupTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	//商品分组查询
	private String[][] rowData2={};
	private String[] columnNames2={"商品名称","交易数量","交易金额","供应商名称"};
	private JTable itemGroupTable=new JTable(rowData2,columnNames2);
	private JScrollPane jsPane2 = new JScrollPane(itemGroupTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);


	private JRadioButton itemgroupButton=new JRadioButton("商品分组查询");
	private JRadioButton suppliergroupButton=new JRadioButton("供应商分组查询");
	private ButtonGroup buttonGroup=new ButtonGroup();

	public ReportManagerUI(){
		this.setTitle("报表管理界面");
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

		itemgroupButton.setBounds(300, 200, 120, 30);
		suppliergroupButton.setBounds(550, 200, 120, 30);

		buttonGroup.add(itemgroupButton);
		buttonGroup.add(suppliergroupButton);

		jsPane.setBounds(250, 280, 600, 250);
		jsPane2.setBounds(250, 280, 600, 250);

		this.add(itemgroupButton);
		this.add(suppliergroupButton);
		this.add(jsPane);
		this.add(jsPane2);
		this.add(timeLabel);
		this.add(usernameLabel);
		this.add(hello);
		this.add(exitPanel);
		this.add(reportsManagerPanel);
		this.add(userManagerPanel);
		this.add(supplierManagerPanel);
		this.add(accountManagerPanel);
		this.add(contentPanel);

		accountManagerPanel.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				ReportManagerUI.this.setVisible(false);
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
				ReportManagerUI.this.setVisible(false);
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
				ReportManagerUI.this.setVisible(false);
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
					ReportManagerUI.this.setVisible(false);
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


		new Thread(this).start();


		/**
		 * 商品分组查询		
		 */
		itemgroupButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jsPane2.setVisible(true);
				jsPane.setVisible(false);
				itemGroupTable.setModel(new ItemGroupTableModel());
				//				ReportManagerUI.this.add(jsPane2);
			}
		});

		/**
		 * 供应商分组查询
		 */

		suppliergroupButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jsPane.setVisible(true);
				jsPane2.setVisible(false);
				supplierGroupTable.setModel(new SupplierGroupTableModel());
				//				ReportManagerUI.this.add(jsPane2);
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
