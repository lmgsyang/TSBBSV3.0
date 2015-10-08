package com.ts.bbs.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.ts.bbs.bean.ReplyBean;
import com.ts.bbs.dao.ReplyDao;
import com.ts.bbs.util.DBConnection;

public class ReplyDaoImpl implements ReplyDao{
   /**
    * 添加回复，调用存储过程，添加回复的同时修改回复量
    */
	@Override
	public int addReply(ReplyBean reply) {
		int row=0;
		Connection conn = null;
		CallableStatement cstmt = null;
		String insertSql = "{call up_addreply(?,?,?,?,?)}";
		try{
		//创建连接
		conn = DBConnection.getConn();
		//创建执行对象
		cstmt = conn.prepareCall(insertSql);
		//给参数赋值
		cstmt.setInt(1, reply.getMsgID());
		cstmt.setInt(2, reply.getUserID());
		cstmt.setString(3, reply.getReplyContent());
		cstmt.setString(4, reply.getReplyTime());
		cstmt.setString(5, reply.getReplyIP());
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

	@Override
	public int updateReplyContents(ReplyBean reply) {
		int row=0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update t_reply set replyContents=? where replyid=?";
		try{
		//创建连接
		conn = DBConnection.getConn();
		//创建执行对象
		pstmt = conn.prepareStatement(sql);
		//给参数赋值
		pstmt.setString(1, reply.getReplyContent());
		pstmt.setInt(2, reply.getReplyID());
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
	public List<ReplyBean> findReplyByMsgid(int msgid) {
		List<ReplyBean> replyList = new ArrayList<ReplyBean>();
		Connection conn = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		String sql = "select * from t_reply where msgid=?";
		try{
			//获取连接
			conn = DBConnection.getConn();
			//创建执行对象
			pstmt = conn.prepareStatement(sql);
			//设置参数
			pstmt.setInt(1, msgid);
			//执行
			rs = pstmt.executeQuery();
			//遍历结果集
			while(rs.next()){
				ReplyBean rep = new ReplyBean();
				rep.setReplyID(rs.getInt(1));
				rep.setMsgID(rs.getInt(2));
				rep.setUserID(rs.getInt(3));
				rep.setReplyContent(rs.getString(4));
				rep.setReplyTime(rs.getString(5));
				rep.setReplyIP(rs.getString(6));
				replyList.add(rep);
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		

		return replyList;
	}

}
