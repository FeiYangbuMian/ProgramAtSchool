package com.qst.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.qst.dao.AdminDao;
import com.qst.model.CourseModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class RegisterFrameCou extends JFrame {

	private JPanel contentPane;
	private JTextField txtCno;
	private JTextField txtCname;
	private JTextField txtCcredit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterFrameCou frame = new RegisterFrameCou();
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
	public RegisterFrameCou() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(480, 200, 411, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCno = new JLabel("课程号");
		lblCno.setFont(new Font("宋体", Font.PLAIN, 14));
		lblCno.setBounds(77, 72, 54, 15);
		contentPane.add(lblCno);
		
		txtCno = new JTextField();
		txtCno.setBounds(154, 69, 149, 21);
		contentPane.add(txtCno);
		txtCno.setColumns(10);
		
		JLabel lblCname = new JLabel("课程名");
		lblCname.setFont(new Font("宋体", Font.PLAIN, 14));
		lblCname.setBounds(77, 135, 54, 15);
		contentPane.add(lblCname);
		
		txtCname = new JTextField();
		txtCname.setBounds(154, 132, 149, 21);
		contentPane.add(txtCname);
		txtCname.setColumns(10);
		
		JLabel lblCcredit = new JLabel("学  分");
		lblCcredit.setFont(new Font("宋体", Font.PLAIN, 14));
		lblCcredit.setBounds(77, 198, 54, 15);
		contentPane.add(lblCcredit);
		
		txtCcredit = new JTextField();
		txtCcredit.setBounds(154, 195, 149, 21);
		contentPane.add(txtCcredit);
		txtCcredit.setColumns(10);
		
		JButton butRegister = new JButton("注册");
		butRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String cno = txtCno.getText();
				//判断用户名和密码
				if(cno==null || "".equals(cno) ){
					JOptionPane.showMessageDialog(null, "课程号不可为空！","错误提示",JOptionPane.ERROR_MESSAGE);	
				}	
				String cname = txtCname.getText();		
				int ccredit = Integer.parseInt(txtCcredit.getText());
				
				CourseModel user = new CourseModel();
				user.setCno(cno);
				user.setCname(cname);
				user.setCcredit(ccredit);
				
				AdminDao dao = new AdminDao();
				//调用数据库操作类进行注册操作
				if(dao.addCourseModel(user)){
					JOptionPane.showMessageDialog(null, "注册成功");
					//跳转到管理员主页面
					new MainFrameAdm().setVisible(true);
					RegisterFrameCou.this.setVisible(false);					
				}else{
					JOptionPane.showMessageDialog(null, "注册失败","错误提示",JOptionPane.ERROR_MESSAGE);	
				}									
			
			}
		});
		butRegister.setBounds(38, 287, 93, 23);
		contentPane.add(butRegister);
		
		JButton butCanel = new JButton("重置");
		butCanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCno.setText(null);
				txtCname.setText(null);
				txtCcredit.setText(null);
			}
		});
		butCanel.setBounds(150, 287, 93, 23);
		contentPane.add(butCanel);
		
		JButton btnReturn = new JButton("返回");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainFrameAdm().setVisible(true);	
				RegisterFrameCou.this.setVisible(false);
			}
		});
		btnReturn.setBounds(262, 287, 93, 23);
		contentPane.add(btnReturn);
		
		JLabel labWelcome = new JLabel("您当前在进行课程注册…");
		labWelcome.setForeground(Color.DARK_GRAY);
		labWelcome.setFont(new Font("方正姚体", Font.PLAIN, 14));
		labWelcome.setBounds(198, 341, 187, 15);
		contentPane.add(labWelcome);
	}
}
