package com.ts.bbs.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ts.bbs.bean.User;
import com.ts.bbs.dao.UserDao;
import com.ts.bbs.util.DBConnection;

public class UserDaoImpl implements UserDao {

	@Override
	public int addUser(User user) {
		Connection conn = null;//连接对象
		PreparedStatement pstmt = null;//参数化执行对象
		int result = 0; //数据库操作影响的行数（增删改相同）
		String sql = "insert into t_user values(?,?,?,?,?,?,?,?,?)";
		try {
			//1获得连接
			conn = DBConnection.getConn();
			//2创建执行对象
			pstmt = conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getSex());
			pstmt.setString(4, user.getHobbys());
			pstmt.setDate(5, user.getBirthday());
			pstmt.setString(6, user.getCity());
			pstmt.setString(7, user.getEmail());
			pstmt.setString(8, user.getQq());
			pstmt.setString(9, user.getCreatetime());
           //4执行
			result = pstmt.executeUpdate();
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//关闭资源
			DBConnection.closeStatement(pstmt);
			DBConnection.closeConn(conn);
		}
		
		
		
		return result;
	}

	@Override
	public int deleteUser(int userid) {
		Connection conn = null;//连接对象
		PreparedStatement pstmt = null;//参数化执行对象
		int result = 0; //数据库操作影响的行数（增删改相同）
		String sql = "delete t_user where userid =?";
		try {
			//1获得连接
			conn = DBConnection.getConn();
			//2创建执行对象
			pstmt = conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(1, userid);
			
           //4执行
			result = pstmt.executeUpdate();
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//关闭资源
			DBConnection.closeStatement(pstmt);
			DBConnection.closeConn(conn);
		}
		
		
		
		return result;
	}

	@Override
	public int UpdateUser(User user) {
		Connection conn = null;//连接对象
		PreparedStatement pstmt = null;//参数化执行对象
		int result = 0; //数据库操作影响的行数（增删改相同）
		String sql = "update t_user set username=?,password=?,sex=?,hobbys=?,birthday=?,city=?,email=?,qq=? where userid=?";
		try {
			//1获得连接
			conn = DBConnection.getConn();
			//2创建执行对象
			pstmt = conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getSex());
			pstmt.setString(4, user.getHobbys());
			pstmt.setDate(5, user.getBirthday());
			pstmt.setString(6, user.getCity());
			pstmt.setString(7, user.getEmail());
			pstmt.setString(8, user.getQq());
			pstmt.setInt(9, user.getUserid());//根据id做修改
           //4执行
			result = pstmt.executeUpdate();
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//关闭资源
			DBConnection.closeStatement(pstmt);
			DBConnection.closeConn(conn);
		}
		
		
		
		return result;
	}

	@Override
	public User findById(int userid) {
		User user = null;
    	Connection conn = null;//连接对象（建立通道java-驱动）
    	PreparedStatement pstmt = null;//执行对象（执行sql语句）
        ResultSet rs = null;//结果集（查询数据库返回结果集）    	
    	String sql = "select * from t_user where userid=?";
    	try {
			 //1获得连接
    		conn = DBConnection.getConn();
    		//2创建执行对象
    		pstmt = conn.prepareStatement(sql);
    		//给参数（?）赋值
    		pstmt.setInt(1, userid);
    		//4执行
    		
    		rs = pstmt.executeQuery();
    		
    		if(rs.next()){//判断是否查询到数据
    			user = new User();
    			//把rs中的数据封装到user对象
    			user.setUserid(rs.getInt(1));//rs索引从1开始，表示表中第一列,按照数据库表列的顺序
    			user.setUsername(rs.getString(2));
    			user.setPassword(rs.getString(3));
    			user.setSex(rs.getString(4));
    			user.setHobbys(rs.getString(5));
    			user.setBirthday(rs.getDate(6));
    			user.setCity(rs.getString(7));
    			user.setEmail(rs.getString(8));
    			user.setQq(rs.getString(9));
    			user.setCreatetime(rs.getString(10));
    			
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//关闭资源
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(pstmt);
			DBConnection.closeConn(conn);
		}
    	
    	
    	return user;
	}

	@Override
	public List<User> findAll() {
		
		List<User> list = new ArrayList<User>();
		User user = null;
    	Connection conn = null;//连接对象（建立通道java-驱动）
    	PreparedStatement pstmt = null;//执行对象（执行sql语句）
        ResultSet rs = null;//结果集（查询数据库返回结果集）    	
    	String sql = "select * from t_user";
    	try {
			 //1获得连接
    		conn = DBConnection.getConn();
    		//2创建执行对象
    		pstmt = conn.prepareStatement(sql);
    
    		//3执行
    		
    		rs = pstmt.executeQuery();
    		
    		while(rs.next()){//判断是否查询到数据
    			user = new User();
    			//把rs中的数据封装到user对象
    			user.setUserid(rs.getInt(1));//rs索引从1开始，表示表中第一列,按照数据库表列的顺序
    			user.setUsername(rs.getString(2));
    			user.setPassword(rs.getString(3));
    			user.setSex(rs.getString(4));
    			user.setHobbys(rs.getString(5));
    			user.setBirthday(rs.getDate(6));
    			user.setCity(rs.getString(7));
    			user.setEmail(rs.getString(8));
    			user.setQq(rs.getString(9));
    			user.setCreatetime(rs.getString(10));
    			//将对象添加到集合
    			list.add(user);
    			
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//关闭资源
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(pstmt);
			DBConnection.closeConn(conn);
		}
    	
    	
    	return list;
	}

	@Override
	public User userlogin(String username, String password) {
		User user = null;
    	Connection conn = null;//连接对象（建立通道java-驱动）
    	PreparedStatement pstmt = null;//执行对象（执行sql语句）
        ResultSet rs = null;//结果集（查询数据库返回结果集）    	
    	String sql = "select * from t_user where username=? and password=?";
    	try {
			 //1获得连接
    		conn = DBConnection.getConn();
    		//2创建执行对象
    		pstmt = conn.prepareStatement(sql);
    		//给参数（?）赋值
    		pstmt.setString(1, username);
    		pstmt.setString(2, password);
    		//4执行
    		
    		rs = pstmt.executeQuery();
    		
    		if(rs.next()){//判断是否查询到数据
    			user = new User();
    			//把rs中的数据封装到user对象
    			user.setUserid(rs.getInt(1));//rs索引从1开始，表示表中第一列,按照数据库表列的顺序
    			user.setUsername(rs.getString(2));
    			user.setPassword(rs.getString(3));
    			user.setSex(rs.getString(4));
    			user.setHobbys(rs.getString(5));
    			user.setBirthday(rs.getDate(6));
    			user.setCity(rs.getString(7));
    			user.setEmail(rs.getString(8));
    			user.setQq(rs.getString(9));
    			user.setCreatetime(rs.getString(10));
    			
    		}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//关闭资源
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(pstmt);
			DBConnection.closeConn(conn);
		}
    	return user;
	}

}
