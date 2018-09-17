package com.qst.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
import java.util.Vector;

import com.qst.model.UserStudent;
import com.qst.util.JDBCUtil;
public class StudentDao {

	//查询成绩信息
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
	
	//查询自己信息
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
	//修改密码
	public int updateSpass(UserStudent user){
		int num = 0;
		JDBCUtil util = new JDBCUtil();
		//String sql = "update student set sname = ? , spass = ? , ssex = ? , sage = ? , sdept = ? where sno = ? ";
		String sql = "update student set spass = ? where sno = ? ";
		//num = util.executeUpdate(sql,user.getSname(), user.getSpass(),user.getSsex(),user.getSage(),user.getSdept(),user.getSno());
		num = util.executeUpdate(sql,user.getSpass(),user.getSno());
		util.closeAll();
		return num;		
	}
	
}
