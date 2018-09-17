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
import com.qst.dao.StudentDao;
import com.qst.model.UserStudent;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.Color;

public class MainFrameStu extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrameStu frame = new MainFrameStu(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param loginFrame 
	 */
	public MainFrameStu(final LoginFrame login) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(480, 200, 571, 401);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(204, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("欢迎您，祖国的仙人掌 qwq ");
		lblNewLabel.setForeground(new Color(51, 51, 51));
		lblNewLabel.setFont(new Font("方正姚体", Font.PLAIN, 14));
		lblNewLabel.setBounds(28, 29, 178, 15);
		contentPane.add(lblNewLabel);
		
		JButton btnSelectSco = new JButton("查询成绩信息");
		btnSelectSco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sno=login.txtUser.getText();
				showScoData(sno);
			}
		});
		btnSelectSco.setBounds(223, 81, 127, 23);
		contentPane.add(btnSelectSco);
		
		JButton btnSelectStu = new JButton("查询基础信息");
		btnSelectStu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sno=login.txtUser.getText();
				showStuData(sno);
			}
		});
		btnSelectStu.setBounds(43, 81, 127, 23);
		contentPane.add(btnSelectStu);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 149, 494, 112);
		contentPane.add(scrollPane);
		
		table = new JTable();
		model = new DefaultTableModel();
		table.setModel(model);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);

		JButton btnReturn = new JButton("返回登录");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginFrame().setVisible(true);	
				MainFrameStu.this.setVisible(false);
			}
		});
		btnReturn.setBounds(272, 311, 112, 23);
		contentPane.add(btnReturn);	
		
		JButton btnExit = new JButton("退出系统");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(407, 311, 112, 23);
		contentPane.add(btnExit);
		
		JButton btnUpdatapass = new JButton("修改密码");
		btnUpdatapass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sno=login.txtUser.getText();
				updateSpass();
				showStuData(sno);
			}
		});
		btnUpdatapass.setBounds(407, 81, 112, 23);
		contentPane.add(btnUpdatapass);
		
	}
	//自身信息
	private  void showStuData(String sno){
		//String  sno = textno.getText();
		//String sno = "";
		//if(textno != null){
		// sno = textno.getText();
		//}		
		StudentDao dao = new StudentDao();
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
	//成绩
	private void showScoData(String sno){
		StudentDao dao = new StudentDao();
		Vector<String> title = new Vector<String>();
		title.add("学号");
		title.add("课程号");
		title.add("成绩");				
		Vector<Vector<String>> userList = dao.getUserScoBySnoVector(sno);
		if(userList.size() > 0 ){
			model.setDataVector(userList, title);
		}else{
			model.setDataVector(null, title);
		}			
	}
	
	private void updateSpass(){		
		int n = table.getSelectedRow();
		if(n>=0){
			UserStudent user=new UserStudent();	
			user.setSpass(table.getValueAt(n, 2).toString());		
			user.setSno(table.getValueAt(n, 0).toString());;
			StudentDao dao = new StudentDao();
			int m = dao.updateSpass(user);
			if(m>0){
				JOptionPane.showMessageDialog(null, "修改成功！");
			}else{
				JOptionPane.showMessageDialog(null, "修改失败！","修改失败",JOptionPane.ERROR_MESSAGE);
			}
		}else{
			JOptionPane.showMessageDialog(null, "修改失败！请选中行","修改失败",JOptionPane.ERROR_MESSAGE);	
		}		
	}
}
