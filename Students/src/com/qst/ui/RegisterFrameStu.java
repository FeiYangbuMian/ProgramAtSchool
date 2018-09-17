package com.qst.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import com.qst.dao.AdminDao;
import com.qst.model.UserStudent;
import java.awt.Font;
import java.awt.Color;

public class RegisterFrameStu extends JFrame {

	private JPanel contentPane;
	private JTextField txtSno;
	private JTextField txtSname;
	private JPasswordField txtSpass;
	private JTextField txtSage;
	private JRadioButton radSmale;
	private JComboBox comboSdept;
//	private JComboBox comboSdept;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterFrameStu frame = new RegisterFrameStu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegisterFrameStu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(480, 200, 440, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelSno = new JLabel("学号");
		labelSno.setFont(new Font("宋体", Font.PLAIN, 14));
		labelSno.setBounds(89, 57, 54, 15);
		contentPane.add(labelSno);
		
		txtSno = new JTextField();
		txtSno.setBounds(176, 54, 151, 21);
		contentPane.add(txtSno);
		txtSno.setColumns(10);
		
		JLabel labelSname = new JLabel("姓名");
		labelSname.setFont(new Font("宋体", Font.PLAIN, 14));
		labelSname.setBounds(89, 100, 54, 15);
		contentPane.add(labelSname);
		
		txtSname = new JTextField();
		txtSname.setBounds(176, 97, 151, 21);
		contentPane.add(txtSname);
		txtSname.setColumns(10);
		
		JLabel labelPass = new JLabel("密码");
		labelPass.setFont(new Font("宋体", Font.PLAIN, 14));
		labelPass.setBounds(89, 149, 54, 15);
		contentPane.add(labelPass);
		
		txtSpass = new JPasswordField();
		txtSpass.setBounds(176, 146, 151, 21);
		contentPane.add(txtSpass);
		txtSpass.setColumns(10);
		
		JLabel labelSsex = new JLabel("性别");
		labelSsex.setFont(new Font("宋体", Font.PLAIN, 14));
		labelSsex.setBounds(89, 191, 54, 15);
		contentPane.add(labelSsex);
		
		radSmale = new JRadioButton("男");
		radSmale.setSelected(true);
		radSmale.setBounds(176, 187, 54, 23);
		contentPane.add(radSmale);
		
		JRadioButton radSfemale = new JRadioButton("女");
		radSfemale.setBounds(251, 187, 54, 23);
		contentPane.add(radSfemale);
		
		ButtonGroup  bg = new ButtonGroup();
		bg.add(radSfemale);
		bg.add(radSmale);
		
		JLabel labelSage = new JLabel("年龄");
		labelSage.setFont(new Font("宋体", Font.PLAIN, 14));
		labelSage.setBounds(89, 235, 54, 15);
		contentPane.add(labelSage);
		
		txtSage = new JTextField();
		txtSage.setBounds(176, 232, 151, 21);
		contentPane.add(txtSage);
		txtSage.setColumns(10);
		
		JLabel labelSdept = new JLabel("学院");
		labelSdept.setFont(new Font("宋体", Font.PLAIN, 14));
		labelSdept.setBounds(89, 287, 54, 15);
		contentPane.add(labelSdept);
		
		comboSdept = new JComboBox();
		comboSdept.setModel(new DefaultComboBoxModel(new String[] {"计科学院", "音乐学院"}));
		comboSdept.setSelectedIndex(0);
		comboSdept.setBounds(176, 284, 151, 21);
		contentPane.add(comboSdept);
		
		JButton butRegister = new JButton("注册");
		butRegister.setFont(new Font("宋体", Font.PLAIN, 12));
		butRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String sno = txtSno.getText();
				String sname = txtSname.getText();
				String spass = new String(txtSpass.getPassword());
				//判断用户名和密码
				if((sno==null || "".equals(sno))||(spass==null || "".equals(spass)) ){
					JOptionPane.showMessageDialog(null, "用户名或密码不能为空！","错误提示",JOptionPane.ERROR_MESSAGE);	
				}			
				int ssex = radSmale.isSelected() ? 1 : 0;
				int sage = Integer.parseInt(txtSage.getText());
				String sdept = comboSdept.getSelectedItem().toString();
				
				UserStudent user = new UserStudent();
				user.setSno(sno);
				user.setSname(sname);
				user.setSpass(spass);
				user.setSsex(ssex);
				user.setSage(sage);
				user.setSdept(sdept);
				
				AdminDao dao = new AdminDao();
				//调用数据库操作类进行注册操作
				if(dao.addUserStudent(user)){
					JOptionPane.showMessageDialog(null, "注册成功");
					//跳转到管理员主页面
					new MainFrameAdm().setVisible(true);
					RegisterFrameStu.this.setVisible(false);					
				}else{
					JOptionPane.showMessageDialog(null, "注册失败","错误提示",JOptionPane.ERROR_MESSAGE);	
				}									
			
			}
		});
		butRegister.setBounds(68, 344, 93, 23);
		contentPane.add(butRegister);
		
		JButton butCanel = new JButton("重置");
		butCanel.setFont(new Font("宋体", Font.PLAIN, 12));
		butCanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtSno.setText(null);
				txtSname.setText(null);
				txtSpass.setText(null);
				txtSage.setText(null);			
			}
		});
		butCanel.setBounds(163, 344, 93, 23);
		contentPane.add(butCanel);
		
		JButton btnReturn = new JButton("返回");
		btnReturn.setFont(new Font("宋体", Font.PLAIN, 12));
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainFrameAdm().setVisible(true);	
				RegisterFrameStu.this.setVisible(false);
			}
		});
		btnReturn.setBounds(258, 344, 93, 23);
		contentPane.add(btnReturn);
		
		JLabel labWelcome = new JLabel("您当前在进行学生注册…");
		labWelcome.setForeground(Color.DARK_GRAY);
		labWelcome.setFont(new Font("方正姚体", Font.PLAIN, 14));
		labWelcome.setBounds(240, 390, 174, 15);
		contentPane.add(labWelcome);
	}
}
