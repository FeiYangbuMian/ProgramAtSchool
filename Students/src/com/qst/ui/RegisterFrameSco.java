package com.qst.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import com.qst.dao.TeacherDao;
import com.qst.model.ScoreModel;


public class RegisterFrameSco extends JFrame {
	


	private JPanel contentPane;
	private JTextField txtSno;
	private JTextField txtCno;
	private JTextField txtGrade;

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
	public RegisterFrameSco() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(480, 200, 422, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSno = new JLabel("学号");
		lblSno.setFont(new Font("宋体", Font.PLAIN, 14));
		lblSno.setBounds(77, 72, 54, 15);
		contentPane.add(lblSno);
		
		txtSno = new JTextField();
		txtSno.setBounds(154, 69, 149, 21);
		contentPane.add(txtSno);
		txtSno.setColumns(10);
		
		JLabel lblCno = new JLabel("课程号");
		lblCno.setFont(new Font("宋体", Font.PLAIN, 14));
		lblCno.setBounds(77, 135, 54, 15);
		contentPane.add(lblCno);
		
		txtCno = new JTextField();
		txtCno.setBounds(154, 132, 149, 21);
		contentPane.add(txtCno);
		txtCno.setColumns(10);
		
		JLabel lblGrade = new JLabel("成绩");
		lblGrade.setFont(new Font("宋体", Font.PLAIN, 14));
		lblGrade.setBounds(77, 198, 54, 15);
		contentPane.add(lblGrade);
		
		txtGrade = new JTextField();
		txtGrade.setBounds(154, 195, 149, 21);
		contentPane.add(txtGrade);
		txtGrade.setColumns(10);
		
		JButton butRegister = new JButton("注册");
		butRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sno = txtSno.getText();
				String cno = txtCno.getText();
				//判断用户名和密码
				if((sno==null || "".equals(sno))||(cno==null || "".equals(cno)) ){
					JOptionPane.showMessageDialog(null, "学号与课程号不可为空！","错误提示",JOptionPane.ERROR_MESSAGE);	
				}	
				int grade = Integer.parseInt(txtGrade.getText());
				
				ScoreModel user = new ScoreModel();
				user.setSno(sno);
				user.setCno(cno);
				user.setGrade(grade);
				
				TeacherDao dao = new TeacherDao();
				//调用数据库操作类进行注册操作
				if(dao.addScoreModel(user)){
					JOptionPane.showMessageDialog(null, "注册成功");
					//跳转到教师主页面
					new MainFrameAdm().setVisible(true);
					RegisterFrameSco.this.setVisible(false);					
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
				txtSno.setText(null);
				txtCno.setText(null);
				txtGrade.setText(null);
			}
		});
		butCanel.setBounds(150, 287, 93, 23);
		contentPane.add(butCanel);
		
		JButton btnReturn = new JButton("返回");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainFrameTea().setVisible(true);	
				RegisterFrameSco.this.setVisible(false);
			}
		});
		btnReturn.setBounds(262, 287, 93, 23);
		contentPane.add(btnReturn);
		
		JLabel labWelcome = new JLabel("您当前在进行学生成绩注册…");
		labWelcome.setForeground(new Color(51, 51, 51));
		labWelcome.setFont(new Font("方正姚体", Font.PLAIN, 14));
		labWelcome.setBounds(192, 353, 204, 15);
		contentPane.add(labWelcome);
	}

	
}
