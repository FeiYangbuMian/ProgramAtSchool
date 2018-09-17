package com.qst.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;


import javax.swing.border.EmptyBorder;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.table.DefaultTableModel;

import com.qst.dao.AdminDao;
import com.qst.model.CourseModel;
import com.qst.model.UserStudent;
import com.qst.model.UserTeacher;

import java.awt.Font;
import java.awt.List;
import javax.swing.JRadioButton;
import java.awt.Color;

public class MainFrameAdm extends JFrame {

	private JPanel contentPane;
	private JTable table;
    private DefaultTableModel model;
    private JTextField textno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrameAdm frame = new MainFrameAdm();
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
	public MainFrameAdm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(480, 200, 616, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("欢迎您，管理员同志 QAQ ");
		lblNewLabel.setForeground(new Color(51, 51, 51));
		lblNewLabel.setFont(new Font("方正姚体", Font.PLAIN, 14));
		lblNewLabel.setBounds(21, 20, 205, 15);
		contentPane.add(lblNewLabel);
		
		JButton btnRegisterStu = new JButton("注册学生信息");
		btnRegisterStu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegisterFrameStu().setVisible(true);	
				MainFrameAdm.this.setVisible(false);
			}
		});
		btnRegisterStu.setBounds(64, 58, 112, 23);
		contentPane.add(btnRegisterStu);
		
		JButton btnRegisterTea = new JButton("注册教师信息");
		btnRegisterTea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegisterFrameTea().setVisible(true);	
				MainFrameAdm.this.setVisible(false);
			}
		});
		btnRegisterTea.setBounds(235, 58, 112, 23);
		contentPane.add(btnRegisterTea);
		
		JButton btnRegisterCourse = new JButton("注册课程信息");
		btnRegisterCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RegisterFrameCou().setVisible(true);	
				MainFrameAdm.this.setVisible(false);
			}
		});
		btnRegisterCourse.setBounds(407, 58, 112, 23);
		contentPane.add(btnRegisterCourse);
		
		JButton btnRunStu = new JButton("查询学生信息");
		btnRunStu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0 ) {
					showStuData();
			}
		});
		btnRunStu.setBounds(64, 90, 112, 23);
		contentPane.add(btnRunStu);
		
		JButton btnRunTea = new JButton("查询教师信息");
		btnRunTea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				showTeaData();
			}
		});
		btnRunTea.setBounds(235, 90, 112, 23);
		contentPane.add(btnRunTea);
		
		JButton btnRunCourse = new JButton("查询课程信息");
		btnRunCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showCouData();
			}
		});
		btnRunCourse.setBounds(407, 90, 112, 23);
		contentPane.add(btnRunCourse);
		
		JButton btnReturn = new JButton("返回登录");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginFrame().setVisible(true);	
				MainFrameAdm.this.setVisible(false);
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
		scrollPane.setBounds(21, 196, 558, 213);
		contentPane.add(scrollPane);
		
		table = new JTable();
		model = new DefaultTableModel();
		table.setModel(model);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		textno = new JTextField();
		textno.setBounds(184, 125, 195, 21);
		contentPane.add(textno);
		textno.setColumns(10);
		
		/*JButton btnSelect = new JButton("查询");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				showTeaData();
				showCouData();
				showStuData();
			}
		});
		btnSelect.setBounds(192, 117, 67, 23);
		contentPane.add(btnSelect);*/
		
		JLabel lbll = new JLabel(" 标  识");
		lbll.setFont(new Font("宋体", Font.PLAIN, 14));
		lbll.setBounds(115, 128, 61, 15);
		contentPane.add(lbll);
		
		final JRadioButton rdbStu = new JRadioButton("学生");
		rdbStu.setSelected(true);
		rdbStu.setBounds(115, 156, 59, 23);
		contentPane.add(rdbStu);
		
		final JRadioButton rdbTea = new JRadioButton("教师");
		rdbTea.setBounds(177, 156, 59, 23);
		contentPane.add(rdbTea);
		
		final JRadioButton rdbCou = new JRadioButton("课程");
		rdbCou.setBounds(238, 156, 59, 23);
		contentPane.add(rdbCou);
		
		ButtonGroup  bg = new ButtonGroup();
		bg.add(rdbStu);
		bg.add(rdbTea);
		bg.add(rdbCou);
		
		JButton btnDelete = new JButton("删除");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbStu.isSelected()){
					deleteStuData();
					showStuData();
				}
				if(rdbTea.isSelected()){
					deleteTeaData();
					showTeaData();
				}
				if(rdbCou.isSelected()){
					deleteCouData();
					showCouData();
				}else{					
					JOptionPane.showMessageDialog(null, "请选择正确的删除用户及其类型！");
				}	
			}
		});
		btnDelete.setBounds(312, 156, 67, 23);
		contentPane.add(btnDelete);
		
		JButton btnUpdate = new JButton("修改");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbStu.isSelected()){
					updateUserBySno();
					showStuData();
				}
				if(rdbTea.isSelected()){
					updateUserByTno();
					showTeaData();
				}
				if(rdbCou.isSelected()){
					updateUserByCno();
					showCouData();
				}
				//else{				
				//JOptionPane.showMessageDialog(null, "请选择正确的修改用户及其类型！");
			//}	
			}
		});
		btnUpdate.setBounds(407, 156, 67, 23);
		contentPane.add(btnUpdate);
		
		JButton btnCancel = new JButton("重置");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textno.setText(null);
			}
		});
		btnCancel.setBounds(407, 123, 67, 23);
		contentPane.add(btnCancel);
		
		
	}
	//查询学生信息
	private  void showStuData(){
		String  sno = textno.getText();
		//String sno = "";
		//if(textno != null){
		// sno = textno.getText();
		//}		
		AdminDao dao = new AdminDao();
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
	//查询教师信息
	private  void showTeaData(){
		String tno = "";
		if(textno != null){
		 tno = textno.getText();
		}		
		AdminDao dao = new AdminDao();
		Vector<String> title = new Vector<String>();
		title.add("工号");
		title.add("姓名");
		title.add("密码");
		title.add("性别");
		title.add("学院");		
		//List<UserStudent> userList = dao.getUserStuBySno(sno);
		Vector<Vector<String>> userList = dao.getUserTeaByTnoVector(tno);
		if(userList.size() > 0 ){
			model.setDataVector(userList, title);
		}else{
			model.setDataVector(null, title);
		}	
	}
	//查询课程信息
	private  void showCouData(){
		
		String cno = "";
		if(textno != null){
		 cno = textno.getText();
		}		
		AdminDao dao = new AdminDao();
		Vector<String> title = new Vector<String>();
		title.add("课程号");
		title.add("课程名");
		title.add("学分");	
		//List<UserStudent> userList = dao.getUserStuBySno(sno);
		Vector<Vector<String>> userList = dao.getUserCouByCnoVector(cno);
		if(userList.size() > 0 ){
			model.setDataVector(userList, title);
		}else{
			model.setDataVector(null, title);
		}	
	}
	
	//删除学生信息
	private void deleteStuData(){
		
		int row = table.getSelectedRow();
		//未选中时，进行提示，请选择
		String sno = table.getValueAt(row, 0).toString();
		AdminDao dao = new AdminDao();
		
		int k = JOptionPane.showConfirmDialog(null, "确定删除当前数据吗？");
		
		if(k==0){
			int num = dao.deleteUserBySno(Integer.parseInt(sno));
			
			if(num>0){
				JOptionPane.showMessageDialog(null, "删除成功");
				//showStuData();
			}else{
				JOptionPane.showMessageDialog(null, "删除失败");
			}
		}		
	}
	//删除教师信息
	private void deleteTeaData(){
		
		int row = table.getSelectedRow();
		//未选中时，进行提示，请选择
		String tno = table.getValueAt(row, 0).toString();
		AdminDao dao = new AdminDao();
		
		int k = JOptionPane.showConfirmDialog(null, "确定删除当前数据吗？");
		
		if(k==0){
			int num = dao.deleteUserByTno(Integer.parseInt(tno));
			
			if(num>0){
				JOptionPane.showMessageDialog(null, "删除成功");
				showTeaData();
			}else{
				JOptionPane.showMessageDialog(null, "删除失败");
			}
		}		
	}
	//删除课程信息
	private void deleteCouData(){		
		int row = table.getSelectedRow();
		//未选中时，进行提示，请选择
		String cno = table.getValueAt(row, 0).toString();
		AdminDao dao = new AdminDao();			
		int k = JOptionPane.showConfirmDialog(null, "确定删除当前数据吗？");			
		if(k==0){
			int num = dao.deleteUserByCno(Integer.parseInt(cno));
				
			if(num>0){
				JOptionPane.showMessageDialog(null, "删除成功");
				showCouData();
			}else{
				JOptionPane.showMessageDialog(null, "删除失败");
			}
		}		
	}	
	//修改学生信息
	private void updateUserBySno(){		
		int n = table.getSelectedRow();
		if(n>=0){
			UserStudent user=new UserStudent();			
			user.setSname(table.getValueAt(n, 1).toString());
			user.setSpass(table.getValueAt(n, 2).toString());		
			//user.setSsex(Integer.parseInt(table.getValueAt(n, 3).toString()));
			user.setSage(Integer.parseInt(table.getValueAt(n, 4).toString()));
			user.setSdept(table.getValueAt(n, 5).toString());
			user.setSno(table.getValueAt(n, 0).toString());;
			AdminDao dao = new AdminDao ();
			int m = dao.updateUserBySno(user);
			if(m>0){
				JOptionPane.showMessageDialog(null, "修改成功！");
			}else{
				JOptionPane.showMessageDialog(null, "修改失败！","修改失败",JOptionPane.ERROR_MESSAGE);
			}
		}else{
			JOptionPane.showMessageDialog(null, "修改失败！请选中行","修改失败",JOptionPane.ERROR_MESSAGE);	
		}		
	}
	//修改教师信息
	private void updateUserByTno(){		
		int n = table.getSelectedRow();
		if(n>=0){
			UserTeacher user=new UserTeacher();			
			user.setTname(table.getValueAt(n, 1).toString());
			user.setTpass(table.getValueAt(n, 2).toString());		
			//user.setTsex(Integer.parseInt(table.getValueAt(n, 3).toString()));
			user.setTdept(table.getValueAt(n, 4).toString());
			user.setTno(table.getValueAt(n, 0).toString());;
			AdminDao dao = new AdminDao ();
			int m = dao.updateUserByTno(user);
			if(m>0){
				JOptionPane.showMessageDialog(null, "修改成功！");
			}else{
				JOptionPane.showMessageDialog(null, "修改失败！","修改失败",JOptionPane.ERROR_MESSAGE);
			}
		}else{
			JOptionPane.showMessageDialog(null, "修改失败！请选中行!","修改失败",JOptionPane.ERROR_MESSAGE);	
		}		
	}
	//修改课程信息
	private void updateUserByCno(){		
		int n = table.getSelectedRow();
		if(n>=0){
			CourseModel user=new CourseModel();			
			user.setCname(table.getValueAt(n, 1).toString());
			user.setCcredit(Integer.parseInt(table.getValueAt(n, 2).toString()));		
			user.setCno(table.getValueAt(n, 0).toString());;
			AdminDao dao = new AdminDao ();
			int m = dao.updateUserByCno(user);
			if(m>0){
				JOptionPane.showMessageDialog(null, "修改成功！");
			}else{
				JOptionPane.showMessageDialog(null, "修改失败！","修改失败",JOptionPane.ERROR_MESSAGE);
			}
		}else{
			JOptionPane.showMessageDialog(null, "修改失败！请选中行!","修改失败",JOptionPane.ERROR_MESSAGE);	
		}		
	}
}
