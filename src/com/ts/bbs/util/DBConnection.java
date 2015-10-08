package com.ts.bbs.util;

import java.sql.*;

/**
 * 数据库连接和关闭公共类
 * 
 * @author Strong
 * 
 */
public class DBConnection {
	private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String URL = "jdbc:sqlserver://localhost:1433;databasename=db_bbs";
	private static final String USER = "sa";
	private static final String PWD = "123456";

	// 注册驱动
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 获得连接
	public static Connection getConn() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL,USER,PWD);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	//关闭连接
	public static void closeConn(Connection conn){
		if(conn != null){
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	//关闭执行对象
	public static void closeStatement(Statement stmt){
		if(stmt != null){
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	//关闭结果集
	public static void closeResultSet(ResultSet rs){
		if(rs != null){
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
