package com.qst.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.qst.dao.AdminDao;
import com.qst.dao.TeacherDao;
import com.qst.model.ScoreModel;
import com.qst.model.UserStudent;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class MainFrameTea extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textsno;
	private DefaultTableModel model;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrameTea frame = new MainFrameTea();
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
	public MainFrameTea() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(480, 200, 623, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("欢迎您，祖国的园丁 (>_<)");
		lblNewLabel.setFont(new Font("方正姚体", Font.PLAIN, 14));
		lblNewLabel.setBounds(27, 20, 213, 15);
		contentPane.add(lblNewLabel);
		
		JButton btnRegisterSco = new JButton("注册成绩信息");
		btnRegisterSco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegisterFrameSco().setVisible(true);
				MainFrameTea.this.setVisible(false);	
			}
		});
		btnRegisterSco.setBounds(64, 62, 112, 23);
		contentPane.add(btnRegisterSco);
		
		JButton btnSelectSco = new JButton("查询成绩信息");
		btnSelectSco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showScoData();
			}
		});
		btnSelectSco.setBounds(407, 62, 112, 23);
		contentPane.add(btnSelectSco);
		
		JButton btnSelectStu = new JButton("查询学生信息");
		btnSelectStu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showStuData();
			}
		});
		btnSelectStu.setBounds(235, 62, 112, 23);
		contentPane.add(btnSelectStu);

		JButton btnReturn = new JButton("返回登录");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginFrame().setVisible(true);	
				MainFrameTea.this.setVisible(false);
			}
		});
		btnReturn.setBounds(301, 425, 112, 23);
		contentPane.add(btnReturn);	
		
		JButton btnExit = new JButton("退出系统");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(461, 425, 112, 23);
		contentPane.add(btnExit);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 167, 552, 228);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		model = new  DefaultTableModel();
		table.setModel(model);
		
		JLabel label = new JLabel("学号");
		label.setFont(new Font("宋体", Font.PLAIN, 14));
		label.setBounds(64, 106, 40, 15);
		contentPane.add(label);
		
		textsno = new JTextField();
		textsno.setBounds(108, 103, 126, 21);
		contentPane.add(textsno);
		textsno.setColumns(10);
		
		JButton btnCancel = new JButton("重置");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textsno.setText(null);
			}
		});
		btnCancel.setBounds(280, 102, 67, 23);
		contentPane.add(btnCancel);
		
		JButton btnSorting = new JButton("排序");
		btnSorting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "没有本功能");
			}
		});
		btnSorting.setBounds(407, 103, 112, 23);
		contentPane.add(btnSorting);		
	}
	
	//查询课程信息
	private  void showScoData(){
		String sno = "";
		if(textsno != null){
		 sno = textsno.getText();
		}		
		TeacherDao dao = new TeacherDao();
		Vector<String> title = new Vector<String>();
		title.add("学号");
		title.add("课程号");
		title.add("成绩");		
		//List<UserStudent> userList = dao.getUserStuBySno(sno);
		Vector<Vector<String>> userList = dao.getUserScoBySnoVector(sno);
		if(userList.size() > 0 ){
			model.setDataVector(userList, title);
		}else{
			model.setDataVector(null, title);
		}	
	}
	
	//查询学生信息
	private  void showStuData(){
		String sno = "";
		if(textsno != null){
			sno = textsno.getText();
		}		
		TeacherDao dao = new TeacherDao();
		Vector<String> title = new Vector<String>();
		title.add("学号");
		title.add("姓名");
		title.add("密码");
		title.add("性别");
		title.add("年龄");
		title.add("学院");		
		//List<UserStudent> userList = dao.getUserStuBySno(sno);
		Vector<Vector<String>> userList = dao.getUserStuBySnoVector(sno);
		if(userList.size() > 0 ){
			model.setDataVector(userList, title);
		}else{
			model.setDataVector(null, title);
		}	
	}
	
	//排序
	
}
