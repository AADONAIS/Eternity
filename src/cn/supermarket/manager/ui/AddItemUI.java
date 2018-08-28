package cn.supermarket.manager.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import cn.supermarket.manager.Service.AccountBeanService;
import cn.supermarket.manager.Service.SupplierBeanService;
import cn.supermarket.manager.entity.AccountBean;
import cn.supermarket.manager.entity.SupplierBean;
import cn.supermarket.manager.entity.UserBean;
import cn.supermarket.manager.exception.MyException;
import cn.supermarket.manager.object.ObjectFactory;

/**
 * �����Ʒ
 * @author Administrator
 *
 */
public class AddItemUI extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//添加必填和非必填标志符号
	private JLabel signLabel=new JLabel("*");
	private JLabel sign2Label=new JLabel("*");
	private JLabel sign3Label=new JLabel("*");
	private JLabel sign4Label=new JLabel("*");
	private JLabel sign5Label=new JLabel("*");
	private JLabel sign6Label=new JLabel("*");
	private JLabel sign7Label=new JLabel("*");
	
	private JLabel itemName=new JLabel("商品名称:");
	private JLabel accountLabel=new JLabel("交易数量:");
	private JLabel unitLabel=new JLabel("交易单位:");
	private JLabel moneyLabel=new JLabel("交易金额:");
	private JLabel ispayedLabel=new JLabel("是否付款:");
	private JLabel supplierLabel=new JLabel("所属供应商:");
	private JLabel descriptionLabel=new JLabel("商品描述:");
	private JLabel timeLabel=new JLabel("交易时间:");
	
	private JTextField itemField=new JTextField(20);
	private JTextField accountField=new JTextField(20);
	private JTextField unitField=new JTextField(20);
	private JTextField moneyField=new JTextField(20);
	private JTextField timeField=new JTextField(20);
	
	private JTextArea descriptionField=new JTextArea(50,50);
	
	private String[] ispayArr= {"请选择","是","否"};
	private JComboBox ispaybox=new JComboBox(ispayArr);
	private JComboBox supplierbox;
	
	private JButton addButton=new JButton("添加");
	private JButton closeButton=new JButton("关闭");
	
	private AccountBean accountBean=new AccountBean();
	private AccountBeanService accountService=(AccountBeanService) ObjectFactory.getInstance("AccountBeanService");
	private SupplierBeanService supplierBeanService=(SupplierBeanService) ObjectFactory.getInstance("SupplierBeanService");
	
	private String supplier = null;	
	
	public AddItemUI() {
		this.setTitle("添加商品");
		this.setSize(500, 700);
		this.setVisible(true);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		signLabel.setBounds(30, 20, 10, 10);
		signLabel.setForeground(Color.RED);
		sign2Label.setBounds(30, 70, 10, 10);
		sign2Label.setForeground(Color.RED);
		sign3Label.setBounds(30, 120, 10, 10);
		sign3Label.setForeground(Color.RED);
		sign4Label.setBounds(30, 170, 10, 10);
		sign4Label.setForeground(Color.RED);
		sign5Label.setBounds(30, 220, 10, 10);
		sign5Label.setForeground(Color.RED);
		sign6Label.setBounds(30, 270, 10, 10);
		sign6Label.setForeground(Color.RED);
		sign7Label.setBounds(30, 400, 10, 10);
		sign7Label.setForeground(Color.RED);
		
		itemName.setBounds(45, 5, 100, 40);
		accountLabel.setBounds(45, 53, 100, 40);
		unitLabel.setBounds(45, 101, 100, 40);
		moneyLabel.setBounds(45, 149, 100, 40);
		ispayedLabel.setBounds(45, 200, 100, 40);
		supplierLabel.setBounds(45, 250, 100, 40);
		descriptionLabel.setBounds(45, 298, 100, 40);
		timeLabel.setBounds(45, 380, 100, 40);
		
		itemField.setBounds(130, 10, 150, 30);
		accountField.setBounds(130, 56, 150, 30);
		unitField.setBounds(130, 105, 150, 30);
		moneyField.setBounds(130, 153, 150, 30);
		timeField.setBounds(130, 385, 200, 30);
		
		supplierBeanService=(SupplierBeanService) ObjectFactory.getInstance("SupplierBeanService");
		List<SupplierBean> list=new ArrayList<SupplierBean>();
		try {
			list=supplierBeanService.queryAll();
		} catch (MyException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		String[] ss=new String[list.size()];
		for (int i = 0; i < ss.length; i++) {
			ss[i]=list.get(i).getS_name();
			
			
		}
		supplierbox=new JComboBox(ss);
		
		ispaybox.setBounds(130, 200, 100, 30);
		supplierbox.setBounds(130, 250, 100, 30);
		
		descriptionField.setBounds(130, 298, 200, 80);
		
		addButton.setBounds(90, 450, 75, 30);
		addButton.setBackground(Color.ORANGE);
		closeButton.setBounds(230, 450, 75, 30);
		closeButton.setBackground(Color.ORANGE);
		
		this.add(itemName);
		this.add(accountLabel);
		this.add(unitLabel);
		this.add(moneyLabel);
		this.add(ispayedLabel);
		this.add(supplierLabel);
		this.add(descriptionLabel);
		this.add(timeLabel);
		
		this.add(itemField);
		this.add(accountField);
		this.add(unitField);
		this.add(moneyField);
		this.add(timeField);
		
		this.add(ispaybox);
		this.add(supplierbox);
		
		this.add(descriptionField);
		
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
//				String supplier = null;				
				accountBean.setA_name(itemField.getText());
				accountBean.setA_nums(Integer.valueOf(accountField.getText()));
				accountBean.setA_unit(unitField.getText());
				accountBean.setA_amount(Double.valueOf(moneyField.getText()));
				accountBean.setA_Date(Date.valueOf(timeField.getText()));
				accountBean.setA_Info(descriptionField.getText());
				if(ispaybox.getSelectedItem().equals(ispaybox.getItemAt(0))){
					JOptionPane.showMessageDialog(new JFrame(), "请选择是否付款！");
				}else if(ispaybox.getSelectedItem().equals(ispaybox.getItemAt(1))){
					accountBean.setA_ispayed(1);
				}else if(ispaybox.getSelectedItem().equals(ispaybox.getItemAt(2))){
					accountBean.setA_ispayed(0);
				}
                accountBean.setS_name(supplierbox.getSelectedItem().toString());
				accountBean.setS_name(supplierbox.getSelectedItem().toString());
				try {
					accountService.add(accountBean);
					JOptionPane.showMessageDialog(new JFrame(), "添加成功");
				} catch (MyException e1) {
					e1.printStackTrace();
				}
			}
		});
		
//		SupplierBeanService supplierBeanService
		
		closeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int result=JOptionPane.showConfirmDialog(new JFrame(),"是否关闭？","关闭提示",JOptionPane.YES_NO_OPTION);
				if(result==0) {
					UserBean user=new UserBean();
				     new MainUI(user);
				}else {
					
				}
			}
		});
		
	}
}
