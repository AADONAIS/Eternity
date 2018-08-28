package cn.supermarket.manager.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import cn.supermarket.manager.Service.UserBeanService;
import cn.supermarket.manager.entity.UserBean;
import cn.supermarket.manager.exception.MyException;
import cn.supermarket.manager.object.ObjectFactory;

public class AddUserUI extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//必填和非必填的标志符号
	private JLabel signLabel=new JLabel("*");
	private JLabel sign2Label=new JLabel("*");
	private JLabel sign3Label=new JLabel("*");
	private JLabel sign4Label=new JLabel("*");
	private JLabel sign5Label=new JLabel("*");
	private JLabel sign6Label=new JLabel("*");
	private JLabel sign7Label=new JLabel("*");
	
	private JLabel unameLabel=new JLabel("姓名:");
	private JLabel pwdLabel=new JLabel("密码:");
	private JLabel confirmpwdLabel=new JLabel("确认密码:");
	private JLabel usexLabel=new JLabel("性别:");
	private JLabel uageLabel=new JLabel("年龄:");
	private JLabel utelLabel=new JLabel("电话:");
	private JLabel uaddrLabel=new JLabel("地址:");
	private JLabel uauthLabel=new JLabel("权限:");
	
	private JTextField nameField=new JTextField(20);
	private JTextField pwdField=new JTextField(20);
	private JTextField cpwdField=new JTextField(20);
	private JTextField ageField=new JTextField(20);
	private JTextField telField=new JTextField(20);
	
	private String[] sexarr= {"男","女"};
	private JComboBox sexbox=new JComboBox(sexarr);
	private String[] autharr= {"普通员工","管理员"};
	private JComboBox authbox=new JComboBox(autharr);
	
	private JTextArea addrArea=new JTextArea(50,50);
	
	private JButton addButton=new JButton("添加");
	private JButton closeButton=new JButton("关闭");
	
	private UserBeanService userService=(UserBeanService) ObjectFactory.getInstance("UserBeanService");
	private UserBean userBean=new UserBean();
	public AddUserUI() {
		this.setTitle("添加用户");
		this.setSize(500, 700);
		this.setVisible(true);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		signLabel.setBounds(30, 30, 15, 15);
		signLabel.setForeground(Color.RED);
		sign2Label.setBounds(30, 80, 15, 15);
		sign2Label.setForeground(Color.RED);
		sign3Label.setBounds(30, 130, 15, 15);
		sign3Label.setForeground(Color.RED);
		sign4Label.setBounds(30, 180, 15, 15);
		sign4Label.setForeground(Color.RED);
		sign5Label.setBounds(30, 230, 15, 15);
		sign5Label.setForeground(Color.RED);
		sign6Label.setBounds(30, 280, 15, 15);
		sign6Label.setForeground(Color.RED);
		sign7Label.setBounds(30, 440, 15, 15);
		sign7Label.setForeground(Color.RED);
		
		unameLabel.setBounds(40, 20, 80, 30);
		pwdLabel.setBounds(40, 70, 80, 30);
		confirmpwdLabel.setBounds(40, 120, 80, 30);
		usexLabel.setBounds(40, 170, 80, 30);
		uageLabel.setBounds(40, 220, 80, 30);
		utelLabel.setBounds(40, 270, 80, 30);
		uaddrLabel.setBounds(40, 320, 80, 30);
		uauthLabel.setBounds(40, 430, 80, 30);
		
		sexbox.setBounds(100, 170, 65, 25);
		authbox.setBounds(100, 430, 100, 25);
		
		nameField.setBounds(100, 25, 130, 25);
		pwdField.setBounds(100, 75, 130, 25);
		cpwdField.setBounds(100, 125, 130, 25);
		ageField.setBounds(100, 225, 130, 25);
		telField.setBounds(100, 275, 130, 25);
		
		addrArea.setBounds(100, 325, 200, 85);
		
		addButton.setBounds(70, 480, 80, 30);
		addButton.setBackground(Color.ORANGE);
		closeButton.setBounds(200, 480, 80, 30);
		closeButton.setBackground(Color.ORANGE);
		
		this.add(unameLabel);
		this.add(pwdLabel);
		this.add(confirmpwdLabel);
		this.add(usexLabel);
		this.add(uageLabel);
		this.add(utelLabel);
		this.add(uaddrLabel);
		this.add(uauthLabel);
		
		this.add(nameField);
		this.add(pwdField);
		this.add(cpwdField);
		this.add(ageField);
		this.add(telField);
		
		this.add(sexbox);
		this.add(authbox);
		
		this.add(addrArea);
		
		this.add(addButton);
		this.add(closeButton);
		
		this.add(signLabel);
		this.add(sign2Label);
		this.add(sign3Label);
		this.add(sign4Label);
		this.add(sign5Label);
		this.add(sign6Label);
		this.add(sign7Label);
		
		
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					userBean.setU_name(nameField.getText());
					userBean.setU_password(pwdField.getText());
					if(!pwdField.getText().equals(cpwdField.getText())){
						JOptionPane.showMessageDialog(new JFrame(), "两次密码输入不相同！");
					}
					userBean.setU_age(Integer.valueOf(ageField.getText()));
					userBean.setU_phone(telField.getText());
					userBean.setU_gender(sexbox.getSelectedItem().toString());
					userBean.setU_auth(authbox.getSelectedItem().toString());
					userBean.setU_address(addrArea.getText());
					userService.regist(userBean);
					JOptionPane.showMessageDialog(new JFrame(), "添加成功!");
				} catch (MyException e1) {
					e1.printStackTrace();
				}
			}
		});
		closeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AddUserUI.this.setVisible(false);
				new UserManagerUI();
			}
		});
		
	}
}
