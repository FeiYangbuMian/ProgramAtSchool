package com.qst.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
import java.util.Vector;

import com.qst.model.ScoreModel;
import com.qst.util.JDBCUtil;

public class TeacherDao {

	//增加成绩信息
	public boolean addScoreModel(ScoreModel user){
		boolean flag = false;
		JDBCUtil util = new JDBCUtil();
		String sql = "insert into score(sno,cno,grade) values(?,?,?)";
		int num = util.executeUpdate(sql,user.getSno(),user.getCno(),user.getGrade());
		if(num>0){
			flag = true;
		}
		util.closeAll();
		return flag;
	}


	//从数据库里取出相应的二维数组
	//学生
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
	
	//成绩
	/*public List<ScoreModel> getUserScoBySno(String sno){
		List<ScoreModel> userlist = new ArrayList<ScoreModel>();
		JDBCUtil util = new JDBCUtil();
		ResultSet rs = null;
		if(sno==null || sno.equals("")){
			String sql = "select * from score";
			rs = util.executeQuery(sql);
		}else{
			String sql = "select * from score where sno = ?";
			rs = util.executeQuery(sql,sno);
		}
		try {
			ScoreModel user = null;
			while(rs.next()){
				user = new ScoreModel();
				user.setSno(rs.getString("sno"));
				user.setCno(rs.getString("cno"));
				user.setGrade(rs.getInt("grade"));
				userlist.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		util.closeAll();
		return userlist;
	}*/
	
	public Vector<Vector<String>> getUserScoBySnoVector(String sno){
		Vector<Vector<String>> userlist = new Vector<Vector<String>>();
		JDBCUtil util = new JDBCUtil();
		ResultSet rs = null;
		if(sno==null || sno.equals("")){
			String sql = "select * from score";
			rs = util.executeQuery(sql);		
		}else{
			String sql = "select * from score where sno = ?";
			rs = util.executeQuery(sql,sno);
		}
		try {
			Vector<String> user = null;
			while(rs.next()){
				user = new Vector<String>();
				user.add(rs.getString("sno"));
				user.add(rs.getString("cno"));
				user.add(String.valueOf(rs.getInt("grade")));
				userlist.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		util.closeAll();
		return userlist;
	}
	
	/*//排序
	public Vector<Vector<String>> getGradeBySnoVector(String sno){
		Vector<Vector<String>> scorelist = new Vector<Vector<String>>();
		JDBCUtil util = new JDBCUtil();
		ResultSet rs = null;
			String sql = "select sno,grade from score group by sno order by grade desc";
			rs = util.executeQuery(sql);
			try {
				Vector<String> score = null;
				while(rs.next()){
					score = new Vector<String>();
					score.add(String.valueOf(rs.getInt("sno")));
					//score.add(rs.getString("courseName"));
					score.add(rs.getString("grade"));
					scorelist.add(score);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		util.closeAll();
		return scorelist;
	}*/
	
}
