package com.qst.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/students";
	private static final String USER_NAME = "root";
	private static final String USER_PASS = "111";

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public JDBCUtil(){
		getConnection();
	}

	public Connection getConnection() {
		try {
			// 1、加载数据库驱动
			Class.forName(DRIVER);
			// 2、创建跟数据库的链接
			conn = DriverManager.getConnection(URL, USER_NAME, USER_PASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;

	}

	public int executeUpdate(String sql, Object... params) {
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
			result = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public ResultSet executeQuery(String sql, Object... params){
		
		try {
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
			rs = ps.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return rs;
	}
	

	public void closeAll() {

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}


}
