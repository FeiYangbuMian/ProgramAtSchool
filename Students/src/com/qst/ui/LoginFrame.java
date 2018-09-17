package com.qst.ui;

import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import java.sql.ResultSet;
import com.qst.util.JDBCUtil;
import java.awt.Font;


public class LoginFrame extends JFrame {

	private JPanel contentPane;
	public JTextField txtUser;
	private JPasswordField txtPass;
	static String username;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(480, 220, 415, 328);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUser = new JLabel("用户名");
		lblUser.setFont(new Font("宋体", Font.PLAIN, 14));
		lblUser.setBounds(86, 116, 54, 15);
		contentPane.add(lblUser);
		
		txtUser = new JTextField();
		txtUser.setBounds(163, 113, 139, 21);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblPass = new JLabel("密  码");
		lblPass.setFont(new Font("宋体", Font.PLAIN, 14));
		lblPass.setBounds(86, 157, 54, 15);
		contentPane.add(lblPass);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(163, 154, 139, 21);
		contentPane.add(txtPass);
		txtPass.setColumns(10);
		
		final JRadioButton rdbtnAdmin = new JRadioButton("管理员");
		rdbtnAdmin.setBounds(86, 195, 71, 23);
		contentPane.add(rdbtnAdmin);
		
		final JRadioButton rdbtnTeacher = new JRadioButton("教  师");
		rdbtnTeacher.setBounds(163, 195, 71, 23);
		contentPane.add(rdbtnTeacher);
		
		final JRadioButton rdbtnStudent = new JRadioButton("学  生");
		rdbtnStudent.setSelected(true);
		rdbtnStudent.setBounds(242, 195, 71, 23);
		contentPane.add(rdbtnStudent);
		
		ButtonGroup  bg = new ButtonGroup();
		bg.add(rdbtnAdmin);
		bg.add(rdbtnTeacher);
		bg.add(rdbtnStudent);
		
		JButton btnLogin = new JButton("登录");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				
				//String name =txtUser.getText();
				//if(name==null || " ".equals(name) ){
				//	JOptionPane.showMessageDialog(null, "用户名不能为空！","错误提示",JOptionPane.ERROR_MESSAGE);	
				//}else{
		 	  //  String pass = txtPass.getText();
				//String pass = new String(((JPasswordField) txtPass).getPassword());
		 	    
				//UserAdmin user = new UserAdmin();
				//user.getName();
				//user.getPass();
				//AdminDao dao = new AdminDao();
				//String name =txtUser.getText();
				//String pass = new String(((JPasswordField) txtPass).getPassword());
				JDBCUtil util = new JDBCUtil();
				ResultSet rs = null;
				int role = 0;	
				if(rdbtnAdmin.isSelected()){
					role = 0;
					String id =txtUser.getText();
					String pass = new String( txtPass.getPassword());
					String sql = "select * from admin where id = ?";
					rs = util.executeQuery(sql,id);
					if((id==null || "".equals(id))||(pass==null|| "".equals(pass)) ){
						JOptionPane.showMessageDialog(null, "标识或密码不能为空！","错误提示",JOptionPane.ERROR_MESSAGE);	
					}else{
						try{
							while(rs.next()){
								//username=rs.getString(2);
								//String aid = rs.getString(1); 
								String apass = rs.getString(3);
								if(!apass.equals(pass)){
									JOptionPane.showMessageDialog(null, "密码错误！");
								}else{
									new MainFrameAdm().setVisible(true);
									//LoginFrame.this.setVisible(false);
								}
							}
						}catch(HeadlessException e1){
							e1.printStackTrace();							
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
					//new MainFrameAdm().setVisible(true);
					//LoginFrame.this.setVisible(false);			
				}
				if(rdbtnTeacher.isSelected()){
					role = 1;
					String tno =txtUser.getText();
					String tpass = new String( txtPass.getPassword());
					String sql = "select * from teacher where tno = ?";
					rs = util.executeQuery(sql,tno);
					if((tno==null || "".equals(tno))||(tpass==null|| "".equals(tpass)) ){
						JOptionPane.showMessageDialog(null, "标识或密码不能为空！","错误提示",JOptionPane.ERROR_MESSAGE);	
					}else{
						try{
							while(rs.next()){
								//username=rs.getString(2);
								//String aid = rs.getString(1); 
								String apass = rs.getString(3);
								if(!apass.equals(tpass)){
									JOptionPane.showMessageDialog(null, "密码错误！");
								}else{
									new MainFrameTea().setVisible(true);
									//LoginFrame.this.setVisible(false);
								}
							
							}
						}catch(HeadlessException e1){
							e1.printStackTrace();							
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
					
					//new MainFrameTea().setVisible(true);
					//LoginFrame.this.setVisible(false);
				}
				if(rdbtnStudent.isSelected()){
					role = 2;
					String sno =txtUser.getText();
					String spass = new String( txtPass.getPassword());
					String sql = "select * from student where sno = ?";
					rs = util.executeQuery(sql,sno);
					if((sno==null || "".equals(sno))||(spass==null|| "".equals(spass))){
						JOptionPane.showMessageDialog(null, "用户名不能为空！","错误提示",JOptionPane.ERROR_MESSAGE);	
					}else{
						try{
							while(rs.next()){
								//username=rs.getString(2);
								//String aid = rs.getString(1); 
								String apass = rs.getString(3);
								if(!apass.equals(spass)){
									JOptionPane.showMessageDialog(null, "密码错误！");
								}else{
									new MainFrameStu(LoginFrame.this).setVisible(true);
									//LoginFrame.this.setVisible(false);
								}						
							}
						}catch(HeadlessException e1){
							e1.printStackTrace();							
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
					//new MainFrameStu().setVisible(true);
					//LoginFrame.this.setVisible(false);
				}
			}			
		});
		
		btnLogin.setBounds(86, 235, 93, 23);
		contentPane.add(btnLogin);
				
		JButton btnCancel = new JButton("重置");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtUser.setText(null);
				txtPass.setText(null);
			}
		});
		btnCancel.setBounds(209, 235, 93, 23);
		contentPane.add(btnCancel);
		
		JLabel label = new JLabel("学生管理系统欢迎您！");
		label.setFont(new Font("华文行楷", Font.PLAIN, 25));
		label.setBounds(80, 43, 250, 46);
		contentPane.add(label);
	}
}