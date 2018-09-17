package com.qst.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.qst.dao.AdminDao;
import com.qst.model.UserTeacher;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterFrameTea extends JFrame {

	private JPanel contentPane;
	private JTextField txtTno;
	private JTextField txtTname;
	private JPasswordField txtTpass;
	private JRadioButton radTmale;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterFrameTea frame = new RegisterFrameTea();
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
	public RegisterFrameTea() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(480, 200, 439, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labTno = new JLabel("工号");
		labTno.setFont(new Font("宋体", Font.PLAIN, 14));
		labTno.setBounds(72, 60, 54, 15);
		contentPane.add(labTno);
		
		txtTno = new JTextField();
		txtTno.setBounds(164, 57, 160, 21);
		contentPane.add(txtTno);
		txtTno.setColumns(10);
		
		JLabel labTname = new JLabel("姓名");
		labTname.setFont(new Font("宋体", Font.PLAIN, 14));
		labTname.setBounds(72, 109, 54, 15);
		contentPane.add(labTname);
		
		txtTname = new JTextField();
		txtTname.setBounds(164, 106, 160, 21);
		contentPane.add(txtTname);
		txtTname.setColumns(10);
		
		JLabel labTpass = new JLabel("密码");
		labTpass.setFont(new Font("宋体", Font.PLAIN, 14));
		labTpass.setBounds(72, 164, 54, 15);
		contentPane.add(labTpass);
		
		txtTpass = new JPasswordField();
		txtTpass.setBounds(164, 161, 160, 21);
		contentPane.add(txtTpass);
		txtTpass.setColumns(10);
		
		JLabel labTsex = new JLabel("性别");
		labTsex.setFont(new Font("宋体", Font.PLAIN, 14));
		labTsex.setBounds(72, 221, 54, 15);
		contentPane.add(labTsex);
		
		radTmale = new JRadioButton("男");
		radTmale.setSelected(true);
		radTmale.setBounds(164, 217, 64, 23);
		contentPane.add(radTmale);
		
		JRadioButton radTfemale = new JRadioButton("女");
		radTfemale.setBounds(253, 217, 71, 23);
		contentPane.add(radTfemale);
		
		ButtonGroup  bg = new ButtonGroup();
		bg.add(radTfemale);
		bg.add(radTmale);
		
		JLabel labTdept = new JLabel("学院");
		labTdept.setFont(new Font("宋体", Font.PLAIN, 14));
		labTdept.setBounds(72, 281, 54, 15);
		contentPane.add(labTdept);
		
		final JComboBox comboTdept = new JComboBox();
		comboTdept.setModel(new DefaultComboBoxModel(new String[] {"计科学院", "音乐学院"}));
		comboTdept.setBounds(164, 278, 160, 21);
		contentPane.add(comboTdept);
		
		JButton buttonReginster = new JButton("注册");
		buttonReginster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String tno = txtTno.getText();
				String tname = txtTname.getText();
				String tpass = new String(txtTpass.getPassword());
				//判断工号和密码
				if((tno==null || "".equals(tno))||(tpass==null || "".equals(tpass)) ){
					JOptionPane.showMessageDialog(null, "用户名或密码不能为空！","错误提示",JOptionPane.ERROR_MESSAGE);	
				}			
				int tsex = radTmale.isSelected() ? 1 : 0;
				String tdept = comboTdept.getSelectedItem().toString();
				
				UserTeacher user = new UserTeacher();
				user.setTno(tno);
				user.setTname(tname);
				user.setTpass(tpass);
				user.setTsex(tsex);
				user.setTdept(tdept);
				
				AdminDao dao = new AdminDao();
				//调用数据库操作类进行注册操作
				if(dao.addUserTeacher(user)){
					JOptionPane.showMessageDialog(null, "注册成功");
					//跳转到管理员主页面
					new MainFrameAdm().setVisible(true);
					RegisterFrameTea.this.setVisible(false);					
				}else{
					JOptionPane.showMessageDialog(null, "注册失败","错误提示",JOptionPane.ERROR_MESSAGE);	
				}													
			}
		});
		buttonReginster.setBounds(61, 351, 93, 23);
		contentPane.add(buttonReginster);
		
		JButton buttonCannel = new JButton("重置");
		buttonCannel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTno.setText(null);
				txtTname.setText(null);
				txtTpass.setText(null);
			}
		});
		buttonCannel.setBounds(164, 351, 93, 23);
		contentPane.add(buttonCannel);
		
		JButton btnReturn = new JButton("返回");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainFrameAdm().setVisible(true);	
				RegisterFrameTea.this.setVisible(false);
			}
		});
		btnReturn.setBounds(267, 351, 93, 23);
		contentPane.add(btnReturn);
		
		JLabel labWelcome = new JLabel("您当前在进行教师注册…");
		labWelcome.setForeground(Color.DARK_GRAY);
		labWelcome.setFont(new Font("方正姚体", Font.PLAIN, 14));
		labWelcome.setBounds(243, 401, 174, 15);
		contentPane.add(labWelcome);
	}

}
