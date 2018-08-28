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
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import sun.applet.Main;

import cn.supermarket.manager.Dao.UserBeanDao;
import cn.supermarket.manager.entity.UserBean;
import cn.supermarket.manager.object.ObjectFactory;

public class MainUI extends JFrame implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Image image;
	private ImageIcon icon;

	private JLabel hello=new JLabel("您好:");
//	private JLabel usernameLabel=new JLabel("mary");
	private UserBean user=new UserBean();
	private JLabel timeLabel=new JLabel();


	String [] rboxarray= {"请选择:","是","否"};
	private JLabel itemName=new JLabel("商品名称:");
	private JTextField itemFiled=new JTextField(20);
	private JLabel chooseLabel=new JLabel("请选择:");
	private JComboBox<String> rbox=new JComboBox<String>(rboxarray);
	private JButton queryButton=new JButton("组合查询");

	private String[][] rowData= {};
	private String[] columnNames= {"账单编号","商品名称","商品数量","交易金额","是否付款","供应商名称","商品描述","账单时间"};

	private JLabel titleLabel=new JLabel("欢迎使用超市管理系统");
	
	private UserBeanDao userDao=(UserBeanDao) ObjectFactory.getInstance("UserBeanDao");
//	private UserBean userBean=new UserBean();
	/**
	 * Create the application.
	 */
	public MainUI(final UserBean user) {
		this.setTitle("主界面");
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
		
		JLabel usernameLabel=new JLabel();
		
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
	    usernameLabel.setText(user.getU_name());
//		usernameLabel.setBackground(Color.GREEN);
		timeLabel.setBounds(700, 70, 130, 50);
		timeLabel.setBackground(Color.ORANGE);
		
//		usernameLabel.setText(userBean.getU_name());
		
		titleLabel.setBounds(400, 300, 400, 150);
		titleLabel.setFont(new Font("楷体", Font.BOLD+Font.ITALIC, 30));
		titleLabel.setForeground(Color.BLUE);

		
		this.add(titleLabel);
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
                 MainUI.this.setVisible(false);
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
				if(user.getU_auth().equals("管理员")){
                   MainUI.this.setVisible(false);
                   new SupplierManagerUI(user);
				}else if(user.getU_auth().equals("普通员工")){
					JOptionPane.showMessageDialog(new JFrame(), "您没有该权限");
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

		userManagerPanel.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				    if(user.getU_auth().equals("管理员")){
                    MainUI.this.setVisible(false);
                    new UserManagerUI();
				    }else if(user.getU_auth().equals("普通员工")){
				    	JOptionPane.showMessageDialog(new JFrame(),"没有该权限");
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

		reportsManagerPanel.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
                    MainUI.this.setVisible(false);
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
					System.exit(0);
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
		//组合查询按钮监听事件
		queryButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		new Thread(this).start();
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
public static void main(String[] args) {
	UserBean user=new UserBean();
	new MainUI(user);
}
}
