package com.ts.bbs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ts.bbs.bean.Admin;
import com.ts.bbs.dao.AdminDao;
import com.ts.bbs.util.DBConnection;

public class AdminDaoImpl implements AdminDao {

	@Override
	public Admin login(String adminname, String adminpassword) {
		Admin admin = null;
    	Connection conn = null;//连接对象（建立通道java-驱动）
    	PreparedStatement pstmt = null;//执行对象（执行sql语句）
        ResultSet rs = null;//结果集（查询数据库返回结果集）    	
    	String sql = "select * from t_admin where adminname=? and adminpassword=?";
    	try {
			 //1获得连接
    		conn = DBConnection.getConn();
    		//2创建执行对象
    		pstmt = conn.prepareStatement(sql);
    		//给参数（?）赋值
    		pstmt.setString(1, adminname);
    		pstmt.setString(2, adminpassword);
    		//4执行
    		
    		rs = pstmt.executeQuery();
    		
    		if(rs.next()){//判断是否查询到数据
    			admin = new Admin();
    			//把rs中的数据封装到user对象
    			admin.setAdminid(rs.getInt(1));//rs索引从1开始，表示表中第一列,按照数据库表列的顺序
    			admin.setAdminname(rs.getString(2));
    			admin.setAdminpassword(rs.getString(3));
    			
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//关闭资源
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(pstmt);
			DBConnection.closeConn(conn);
		}
    	return admin;
	}

}
