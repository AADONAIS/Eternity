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

public class ModifySupplierUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//添加必填和非必填的标志符号
	private JLabel signLabel=new JLabel("*");
	private JLabel sign2Label=new JLabel("*");
	private JLabel sign3Label=new JLabel("*");
	private JLabel sign4Label=new JLabel("*");

	private JLabel supplierName=new JLabel("供应商名称:");
	private JLabel supplierdescription=new JLabel("供应商描述:");
	private JLabel supplierlink=new JLabel("供应商联系人:");
	private JLabel supplierTel=new JLabel("联系电话:");
	private JLabel supplierFax=new JLabel("供应商传真:");
	private JLabel supplierAddress=new JLabel("供应商地址:");

	private JTextField snameField=new JTextField(20);
	private JTextField sfaxField=new JTextField(20);
	private JTextField slinkField=new JTextField(20);
	private JTextField stelField=new JTextField(20);
	private JTextField sAddressField=new JTextField(20);

	private JButton updateButton=new JButton("修改");
	private JButton closeButton=new JButton("关闭");

	private JTextArea sdArea=new JTextArea(100,100);

    private SupplierBean supplierBean=new SupplierBean();
    private SupplierBeanService supplierService=(SupplierBeanService) ObjectFactory.getInstance("SupplierBeanService");

	public ModifySupplierUI(int index,String name,String info,String linkman,String phone,String address,String fax) {
		this.setTitle("修改供应商");
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

		snameField.setBounds(120, 33, 130, 25);
		slinkField.setBounds(120, 160, 130, 25);
		stelField.setBounds(120, 210, 130, 25);
		sfaxField.setBounds(120,255, 130, 25);
		sAddressField.setBounds(120, 298, 130, 25);

		snameField.setText(name);
		slinkField.setText(linkman);
		stelField.setText(phone);
		sfaxField.setText(fax);
		sAddressField.setText(address);
		
		sdArea.setBounds(120, 70, 200, 80);
        sdArea.setText(info);
		updateButton.setBounds(80, 360, 70, 30);
		updateButton.setBackground(Color.ORANGE);
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

		this.add(updateButton);
		this.add(closeButton);

		this.add(signLabel);
		this.add(sign2Label);
		this.add(sign3Label);
		this.add(sign4Label);

		updateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
                supplierBean.setS_name(snameField.getText());
                supplierBean.setS_linkman(slinkField.getText());
                supplierBean.setS_phone(stelField.getText());
                supplierBean.setS_faxes(sfaxField.getText());
                supplierBean.setS_address(sAddressField.getText());
                supplierBean.setS_info(sdArea.getText());
                try {
					supplierService.modify(supplierBean);
				} catch (MyException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(new JFrame(), "修改成功!");
			}
		});

		closeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int result=JOptionPane.showConfirmDialog(new JFrame(),"是否退出?","退出提示",JOptionPane.YES_NO_OPTION);
				if(result==0) {
					UserBean user=new UserBean();
					new MainUI(user);
				}else {

				}
			}
		});


	}
}
