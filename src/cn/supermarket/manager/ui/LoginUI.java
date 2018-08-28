package cn.supermarket.manager.ui;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import cn.supermarket.manager.Dao.UserBeanDao;
import cn.supermarket.manager.Service.UserBeanService;
import cn.supermarket.manager.entity.UserBean;
import cn.supermarket.manager.exception.MyException;
import cn.supermarket.manager.object.ObjectFactory;
import cn.supermarket.manager.util.JDBCUtil;
import cn.supermarket.manager.util.Util;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class LoginUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel username=new JLabel("姓名:");
	private JLabel password=new JLabel("密码:");
	private JLabel auth=new JLabel("身份:");
	private static JTextField nameField=new JTextField(30);
	private JPasswordField pwdField=new JPasswordField(30);

	private JLabel userLabel=new JLabel();

	private Image image;
	private ImageIcon icon;
	private String[] var= {"普通员工","管理员"};

	private JComboBox<String> comboBox=new JComboBox<String>(var);

	private JButton loginButton=new JButton("登录");
	private JButton resetButton=new JButton("重置");
	UserBeanService userService= (UserBeanService) ObjectFactory.getInstance("UserBeanService");
	UserBeanDao userDao=(UserBeanDao) ObjectFactory.getInstance("UserBeanDao");
	/**
	 * Create the frame.
	 */
	public LoginUI() {
		this.setTitle("登录界面");
		this.setSize(600, 500);
		this.setVisible(true);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		JPanel contentPanel=new JPanel(){
			private static final long serialVersionUID = 1L;
			@Override
			public void paint(Graphics g) {
				icon=new ImageIcon("./img/login_box.jpg");
				image=icon.getImage();
				g.drawImage(image, 0,0,null);

			}
		};


		username.setBounds(130, 180, 100, 25);
		username.setFont(new Font("楷体", Font.BOLD, 15));
		nameField.setBounds(180, 180, 150, 25);
		password.setBounds(130, 220, 120, 25);
		password.setFont(new Font("楷体", Font.BOLD, 15));
		pwdField.setBounds(180, 220, 150, 25);
		auth.setBounds(130, 260, 100, 25);
		auth.setFont(new Font("楷体", Font.BOLD, 15));
		comboBox.setBounds(180, 260, 120, 25);
		loginButton.setBounds(130, 300, 80, 35);
		resetButton.setBounds(250, 300, 80, 35);
		contentPanel.setBounds(0, 0, 600, 500);

		this.add(username);
		this.add(nameField);
		this.add(password);
		this.add(pwdField);
		this.add(auth);
		this.add(comboBox);
		this.add(loginButton);
		this.add(resetButton);

		this.add(contentPanel);
		loginButton.addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent e) {
				UserBean user=new UserBean();
				String username=nameField.getText();
				String userpassword=pwdField.getText();
				try {
					user=userService.queryUser(username);

				} catch (MyException e1) {
					e1.printStackTrace();
				}
				userLabel.setText(user.getU_name());


				if(user.getU_auth().equals(comboBox.getSelectedItem())){
					if(username.equals(user.getU_name())){
						if(userpassword.equals(user.getU_password())){
							if(!Util.isAllDigit(username)){
							JOptionPane.showMessageDialog(new JFrame(), "登录成功!");
							LoginUI.this.setVisible(false);
							new MainUI(user);
							}else{
								JOptionPane.showMessageDialog(new JFrame(), "用户名不合法");
							}
						}else{
							JOptionPane.showMessageDialog(new JFrame(), "密码错误!");
						}
					}else{
						JOptionPane.showMessageDialog(new JFrame(), "用户名错误!");
					}
				}else{
					JOptionPane.showMessageDialog(new JFrame(), "您没有权限");
				}

			}

		});

		resetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				nameField.setText("");
				pwdField.setText("");
				comboBox.setSelectedIndex(0);

			}
		});

	}

	public static void main(String[] args) {
		new LoginUI();
	}

}
