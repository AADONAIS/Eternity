package cn.supermarket.manager.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import cn.supermarket.manager.Service.SupplierBeanService;
import cn.supermarket.manager.entity.SupplierBean;
import cn.supermarket.manager.entity.UserBean;
import cn.supermarket.manager.exception.MyException;
import cn.supermarket.manager.object.ObjectFactory;

public class AddSupplierUI extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//添加必填和非必填标志符号
	private JLabel signLabel=new JLabel("*");
	private JLabel sign2Label=new JLabel("*");
	private JLabel sign3Label=new JLabel("*");
	private JLabel sign4Label=new JLabel("*");

	private JLabel supplierName=new JLabel("供应商名称:");
	private JLabel supplierdescription=new JLabel("供应商描述:");
	private JLabel supplierlink=new JLabel("供应商联系人:");
	private JLabel supplierTel=new JLabel("供应商电话:");
	private JLabel supplierFax=new JLabel("供应商传真:");
	private JLabel supplierAddress=new JLabel("供应商地址:");

	private JTextField snameField=new JTextField(20);
	private JTextField sfaxField=new JTextField(20);
	private JTextField slinkField=new JTextField(20);
	private JTextField stelField=new JTextField(20);
	private JTextField sAddressField=new JTextField(20);

	private JButton addButton=new JButton("添加");
	private JButton closeButton=new JButton("关闭");

	private JTextArea sdArea=new JTextArea(100,100);
	
	private SupplierBean supplierBean=new SupplierBean();
	private SupplierBeanService supplierService=(SupplierBeanService) ObjectFactory.getInstance("SupplierBeanService");

	
	public AddSupplierUI(final UserBean user) {
		this.setTitle("添加供应商");
		this.setSize(500, 700);
		this.setVisible(true);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		signLabel.setBounds(20, 40, 15, 15);
		signLabel.setForeground(Color.RED);
		sign2Label.setBounds(20, 170, 15, 15);
		sign2Label.setForeground(Color.RED);
		sign3Label.setBounds(20, 220, 15, 15);
		sign3Label.setForeground(Color.RED);
		sign4Label.setBounds(20, 310, 15, 15);
		sign4Label.setForeground(Color.RED);

		supplierName.setBounds(30, 30, 80, 30);
		supplierdescription.setBounds(30, 65, 80, 30);
		supplierlink.setBounds(30, 160, 100, 30);
		supplierTel.setBounds(30, 208, 80, 30);
		supplierFax.setBounds(30, 255, 80, 30);
		supplierAddress.setBounds(30, 298, 80, 30);

		snameField.setBounds(120, 33, 130, 25);//供应商名称
		slinkField.setBounds(120, 160, 130, 25);//供应商联系人
		stelField.setBounds(120, 210, 130, 25);//供应商电话
		sfaxField.setBounds(120,255, 130, 25);//供应商传真
		sAddressField.setBounds(120, 298, 130, 25); //供应商地址

		sdArea.setBounds(120, 70, 200, 80);

		addButton.setBounds(80, 360, 70, 30);
		addButton.setBackground(Color.ORANGE);
		closeButton.setBounds(220, 360, 70, 30);
		closeButton.setBackground(Color.ORANGE);

		this.add(supplierName);
		this.add(supplierdescription);
		this.add(supplierlink);
		this.add(supplierTel);
		this.add(supplierFax);
		this.add(supplierAddress);

		this.add(snameField);
		this.add(sfaxField);
		this.add(slinkField);
		this.add(stelField);
		this.add(sAddressField);

		this.add(sdArea);

		this.add(addButton);
		this.add(closeButton);

		this.add(signLabel);
		this.add(sign2Label);
		this.add(sign3Label);
		this.add(sign4Label);

		addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
                   supplierBean.setS_name(snameField.getText());
                   supplierBean.setS_info(sdArea.getText());
                   supplierBean.setS_linkman(slinkField.getText());
                   supplierBean.setS_phone(stelField.getText());
                   supplierBean.setS_address(sAddressField.getText());
                   supplierBean.setS_faxes(sfaxField.getText());
                   try {
					supplierService.add(supplierBean);
					JOptionPane.showMessageDialog(new JFrame(), "添加成功!");
				} catch (MyException e1) {
					e1.printStackTrace();
				}
                   
			}
		});

		closeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int result=JOptionPane.showConfirmDialog(new JFrame(),"是否关闭?","关闭提示",JOptionPane.YES_NO_OPTION);
				if(result==0) {
					new MainUI(user);
				}else {

				}
			}
		});
	}

}
