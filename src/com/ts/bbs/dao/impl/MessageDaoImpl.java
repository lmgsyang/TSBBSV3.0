package com.ts.bbs.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.ts.bbs.bean.MessageBean;
import com.ts.bbs.bean.MessageInfoBean;
import com.ts.bbs.dao.MessageDao;
import com.ts.bbs.util.DBConnection;

public class MessageDaoImpl implements MessageDao{

	@Override
	public int addMessage(MessageBean msg) {
		int row = 0;
		Connection conn = null;
		PreparedStatement pstmt= null;
		String sql = "insert into t_message values(?,?,?,?,?)";
		try{
			//获取连接
			conn = DBConnection.getConn();
			//创建执行对象
			pstmt = conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(1, msg.getUserID());
			pstmt.setString(2, msg.getMsgTopic());
			pstmt.setString(3, msg.getMsgContent());
			pstmt.setString(4, msg.getMsgTime());
			pstmt.setString(5, msg.getIP());
			//执行
			row = pstmt.executeUpdate();
		}catch(SQLException ex){
			ex.printStackTrace();
		}finally{
			DBConnection.closeStatement(pstmt);
			DBConnection.closeConn(conn);
		}
		
		return row;
	}
    /**
     * 删除留言，需要删除所有回复，调用存储过程
     */
	@Override
	public int deleteMessage(int msgid) {
		int row = 0;
		Connection conn = null;
		CallableStatement cstmt= null;
		String sql = "{call up_deletemsg(?)}";
		try{
			//获取连接
			conn = DBConnection.getConn();
			//创建执行对象
			cstmt = conn.prepareCall(sql);
			//给参数赋值
			cstmt.setInt(1, msgid);	
			//执行
			row = cstmt.executeUpdate();
		}catch(SQLException ex){
			ex.printStackTrace();
		}finally{
			DBConnection.closeStatement(cstmt);
			DBConnection.closeConn(conn);
		}
		
		return row;
	}
    /**
     * 修改留言标题和内容
     */
	@Override
	public int UpdateMessage(MessageBean msg) {
		int row = 0;
		Connection conn = null;
		PreparedStatement pstmt= null;
		String sql = "update t_message set msgtopic=?,msgcontents=? where msgid=?";
		try{
			//获取连接
			conn = DBConnection.getConn();
			//创建执行对象
			pstmt = conn.prepareStatement(sql);
			//给参数赋值

			pstmt.setString(1, msg.getMsgTopic());
			pstmt.setString(2, msg.getMsgContent());
			pstmt.setInt(3, msg.getUserID());
			//执行
			row = pstmt.executeUpdate();
		}catch(SQLException ex){
			ex.printStackTrace();
		}finally{
			DBConnection.closeStatement(pstmt);
			DBConnection.closeConn(conn);
		}
		
		return row;
	}

	@Override
	public MessageBean findById(int msgid) {
		MessageBean msg=null;
		Connection conn = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		String sql = "select * from t_message where msgid=?";
		try{
			//获取连接
			conn = DBConnection.getConn();
			//创建执行对象
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, msgid);
			//执行
			rs = pstmt.executeQuery();
			//遍历结果集
			while(rs.next()){
				msg = new MessageBean();
				msg.setMsgID(rs.getInt(1));
				msg.setUserID(rs.getInt(2));
				msg.setMsgTopic(rs.getString(3));
				msg.setMsgContent(rs.getString(4));
				msg.setMsgTime(rs.getString(5));
				msg.setIP(rs.getString(6));		
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}finally{
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(pstmt);
			DBConnection.closeConn(conn);
		}
		
		return msg;
	}
    /**
     * 修改访问量，当链接某个主题，该主题对应的访问量增加
     */
	@Override
	public int updateAccessCount(int msgid) {
		int row = 0;
		Connection conn = null;
		PreparedStatement pstmt= null;
		String sql = "update t_countmsg set accessCount=accessCount+1 where msgid=?";
		try{
			//获取连接
			conn = DBConnection.getConn();
			//创建执行对象
			pstmt = conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(1,msgid);
			//执行
			row = pstmt.executeUpdate();
		}catch(SQLException ex){
			ex.printStackTrace();
		}finally{
			DBConnection.closeStatement(pstmt);
			DBConnection.closeConn(conn);
		}
		
		return row;
	}

	@Override
	public List<MessageInfoBean> findAll() {
		List<MessageInfoBean> msginfolist = new ArrayList<MessageInfoBean>();
		Connection conn = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		String sql = "select * from v_msginfo order by msgid desc";
		try{
			//获取连接
			conn = DBConnection.getConn();
			//创建执行对象
			pstmt = conn.prepareStatement(sql);
			//执行
			rs = pstmt.executeQuery();
			//遍历结果集
			while(rs.next()){
			    MessageInfoBean	msg = new MessageInfoBean();
				msg.setMsgID(rs.getInt(1));
				msg.setMsgTopic(rs.getString(2));
				msg.setUserID(rs.getInt(3));
				msg.setUserName(rs.getString(4));
				msg.setAccessCount(rs.getInt(5));
				msg.setReplyCount(rs.getInt(6));
				msg.setMsgTime(rs.getString(7));
				msginfolist.add(msg);
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}finally{
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(pstmt);
			DBConnection.closeConn(conn);
		}
		
		return msginfolist;
	}

}
