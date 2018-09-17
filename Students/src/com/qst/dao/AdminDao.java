package com.qst.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
import java.util.Vector;

import com.qst.model.CourseModel;
import com.qst.model.UserStudent;
import com.qst.model.UserTeacher;
import com.qst.util.JDBCUtil;

public class AdminDao {

	/**
	 * 用户添加操作
	 * @param user 封装用户信息
	 * @return  true:插入成功
	 */
	
	//增加学生
	public boolean addUserStudent(UserStudent user){
		boolean flag = false;
		JDBCUtil util = new JDBCUtil();
		String sql = "insert into student(sno,sname,spass,ssex,sage,sdept) values(?,?,?,?,?,?)";
		int num = util.executeUpdate(sql, user.getSno(),user.getSname(),user.getSpass(),user.getSsex(),user.getSage(),user.getSdept());
		if(num>0){
			flag = true;
		}
		util.closeAll();
		return flag;
	}
	//增加教师
	public boolean addUserTeacher(UserTeacher user){
		boolean flag = false;
		JDBCUtil util = new JDBCUtil();
		String sql = "insert into teacher(tno,tname,tpass,tsex,tdept) values(?,?,?,?,?)";
		int num = util.executeUpdate(sql, user.getTno(),user.getTname(),user.getTpass(),user.getTsex(),user.getTdept());
		if(num>0){
			flag = true;
		}
		util.closeAll();
		return flag;
	}
	//增加课程
	public boolean addCourseModel(CourseModel user){
		boolean flag = false;
		JDBCUtil util = new JDBCUtil();
		String sql = "insert into course(cno,cname,ccredit) values(?,?,?)";
		int num = util.executeUpdate(sql, user.getCno(),user.getCname(),user.getCcredit());
		if(num>0){
			flag = true;
		}
		util.closeAll();
		return flag;
	}
	
	
	//学生
	/*定义了一个通过学生学号获取学生信息的函数，在函数里，
	 * 首先定义一个List用来接收sql传来的数据，
	然后新建JDBCUtil，这是别人给你提供好的操作数据库的对象，
	然后ResultSet是一个dateset，可以理解为像excel一样的表
	用来接收传来的表的数据，接下来几行的意思是，
	如果给定了筛选条件，就在sql端执行select * from student where sno = ?，
	否则就获取所有学生信息，然后就开始从获取到的dataset中，
	也就是数据集中一行行读取数据，用一个while实现，
	当return userList的时候，就已经把获取到的所有学生信息都返回了*/
	/*public List<UserStudent> getUserStuBySno(String sno){
		List<UserStudent> userlist = new ArrayList<UserStudent>();
		JDBCUtil util = new JDBCUtil();
		ResultSet rs = null;
		if(sno==null || sno.equals("")){
			String sql = "select * from student";
			rs = util.executeQuery(sql);
		}else{
			String sql = "select * from student where sno = ?";
			rs = util.executeQuery(sql,sno);
		}
		try {
			UserStudent user = null;
			while(rs.next()){
				user = new UserStudent();
				user.setSno(rs.getString("sno"));
				user.setSname(rs.getString("ssname"));
				user.setSpass(rs.getString("spass"));
				user.setSsex(rs.getInt("ssex"));
				user.setSage(rs.getInt("sage"));
				user.setSdept(rs.getString("sdept"));
				userlist.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		util.closeAll();
		return userlist;
	}*/
	
	public Vector<Vector<String>> getUserStuBySnoVector(String sno){
		Vector<Vector<String>> userlist = new Vector<Vector<String>>();
		JDBCUtil util = new JDBCUtil();
		ResultSet rs = null;
		if(sno==null || sno.equals("")){
			String sql = "select * from student";
			rs = util.executeQuery(sql);		
		}else{
			String sql = "select * from student where sno = ?";
			rs = util.executeQuery(sql,sno);
		}
		try {
			Vector<String> user = null;
			while(rs.next()){
				user = new Vector<String>();
				user.add(rs.getString("sno"));
				user.add(rs.getString("sname"));
				user.add(rs.getString("spass"));
				user.add(rs.getInt("ssex")==1?"男":"女");
				user.add(String.valueOf(rs.getInt("sage")));
				user.add(rs.getString("sdept"));
				userlist.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		util.closeAll();
		return userlist;
	}
	
	//教师
	/*public List<UserTeacher> getUserTeaBySno(String tno){
		List<UserTeacher> userlist = new ArrayList<UserTeacher>();
		JDBCUtil util = new JDBCUtil();
		ResultSet rs = null;
		if(tno==null || tno.equals("")){
			String sql = "select * from teacher";
			rs = util.executeQuery(sql);
		}else{
			String sql = "select * from teacher where tno = ?";
			rs = util.executeQuery(sql,tno);
		}
		try {
			UserTeacher user = null;
			while(rs.next()){
				user = new UserTeacher();
				user.setTno(rs.getString("tno"));
				user.setTname(rs.getString("tsname"));
				user.setTpass(rs.getString("tpass"));
				user.setTsex(rs.getInt("tsex"));
				user.setTdept(rs.getString("tdept"));
				userlist.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		util.closeAll();
		return userlist;
	}*/
	
	public Vector<Vector<String>> getUserTeaByTnoVector(String tno){
		Vector<Vector<String>> userlist = new Vector<Vector<String>>();
		JDBCUtil util = new JDBCUtil();
		ResultSet rs = null;
		if(tno==null || tno.equals("")){
			String sql = "select * from teacher";
			rs = util.executeQuery(sql);		
		}else{
			String sql = "select * from teacher where tno = ?";
			rs = util.executeQuery(sql,tno);
		}
		try {
			Vector<String> user = null;
			while(rs.next()){
				user = new Vector<String>();
				user.add(rs.getString("tno"));
				user.add(rs.getString("tname"));
				user.add(rs.getString("tpass"));
				user.add(rs.getInt("tsex")==1?"男":"女");
				user.add(rs.getString("tdept"));
				userlist.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		util.closeAll();
		return userlist;
	}
	
	//课程
	/*public List<CourseModel> getUserCouByCno(String cno){
		List<CourseModel> userlist = new ArrayList<CourseModel>();
		JDBCUtil util = new JDBCUtil();
		ResultSet rs = null;
		if(cno==null || cno.equals("")){
			String sql = "select * from course";
			rs = util.executeQuery(sql);
		}else{
			String sql = "select * from course where tno = ?";
			rs = util.executeQuery(sql,cno);
		}
		try {
			CourseModel user = null;
			while(rs.next()){
				user = new CourseModel();
				user.setCno(rs.getString("cno"));
				user.setCname(rs.getString("cname"));
				user.setCcredit(rs.getInt("ccredit"));
				userlist.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		util.closeAll();
		return userlist;
	}*/

	public Vector<Vector<String>> getUserCouByCnoVector(String cno){
		Vector<Vector<String>> userlist = new Vector<Vector<String>>();
		JDBCUtil util = new JDBCUtil();
		ResultSet rs = null;
		if(cno==null || cno.equals("")){
			String sql = "select * from course";
			rs = util.executeQuery(sql);		
		}else{
			String sql = "select * from course where cno = ?";
			rs = util.executeQuery(sql,cno);
		}
		try {
			Vector<String> user = null;
			while(rs.next()){
				user = new Vector<String>();
				user.add(rs.getString("cno"));
				user.add(rs.getString("cname"));
				user.add(String.valueOf(rs.getInt("ccredit")));
				userlist.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		util.closeAll();
		return userlist;
	}
	
	
	//删学生信息
	public int deleteUserBySno(int sno){
		int num = 0;
		JDBCUtil util = new JDBCUtil();
		String sql = "delete from student where sno = ?";
		num = util.executeUpdate(sql, sno);
		util.closeAll();
		return num;
	}
	//删除教师信息
	public int deleteUserByTno(int tno){
		int num = 0;
		JDBCUtil util = new JDBCUtil();
		String sql = "delete from teacher where tno = ?";
		num = util.executeUpdate(sql, tno);
		util.closeAll();
		return num;
	}
	//删除课程信息
	public int deleteUserByCno(int cno){
		int num = 0;
		JDBCUtil util = new JDBCUtil();
		String sql = "delete from course where cno = ?";
		num = util.executeUpdate(sql, cno);
		util.closeAll();
		return num;
	}

	//修改学生
	public int updateUserBySno(UserStudent user){
		int num = 0;
		JDBCUtil util = new JDBCUtil();
		//String sql = "update student set sname = ? , spass = ? , ssex = ? , sage = ? , sdept = ? where sno = ? ";
		String sql = "update student set sname = ? , spass = ? , sage = ? , sdept = ? where sno = ? ";
		//num = util.executeUpdate(sql,user.getSname(), user.getSpass(),user.getSsex(),user.getSage(),user.getSdept(),user.getSno());
		num = util.executeUpdate(sql,user.getSname(), user.getSpass(),user.getSage(),user.getSdept(),user.getSno());
		util.closeAll();
		return num;		
	}
	//修改教师
	public int updateUserByTno(UserTeacher user){
		int num = 0;
		JDBCUtil util = new JDBCUtil();
		String sql = "update teacher set tname = ? , tpass = ? , tdept = ? where tno = ? ";
		num = util.executeUpdate(sql, user.getTname(),user.getTpass(),user.getTdept(),user.getTno());
		util.closeAll();
		return num;		
	}
	//修改课程
	public int updateUserByCno(CourseModel user){
		int num = 0;
		JDBCUtil util = new JDBCUtil();
		String sql = "update course set cname = ? , ccredit = ? where cno = ? ";
		num = util.executeUpdate(sql, user.getCname(),user.getCcredit(),user.getCno());
		util.closeAll();
		return num;		
	}
}
