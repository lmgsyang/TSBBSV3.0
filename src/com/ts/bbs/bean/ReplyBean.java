package com.ts.bbs.bean;

public class ReplyBean {
	  private int replyID;
	  private int msgID;
	  private int userID;
	  private String replyContent;
	  private String replyTime;
	  private String replyIP;
	public int getReplyID() {
		return replyID;
	}
	public void setReplyID(int replyID) {
		this.replyID = replyID;
	}
	public int getMsgID() {
		return msgID;
	}
	public void setMsgID(int msgID) {
		this.msgID = msgID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public String getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(String replyTime) {
		this.replyTime = replyTime;
	}
	public String getReplyIP() {
		return replyIP;
	}
	public void setReplyIP(String replyIP) {
		this.replyIP = replyIP;
	}
}
