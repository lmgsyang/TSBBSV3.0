package com.ts.bbs.bean;

public class MessageBean {
	private int msgID;
	private int userID;
	private String msgTopic;
	private String msgContent;
	private String msgTime;
	private String IP;
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
	
	public String getMsgTopic() {
		return msgTopic;
	}
	public void setMsgTopic(String msgTopic) {
		this.msgTopic = msgTopic;
	}
	public String getMsgContent() {
		return msgContent;
	}
	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}
	public String getMsgTime() {
		return msgTime;
	}
	public void setMsgTime(String msgTime) {
		this.msgTime = msgTime;
	}
	public String getIP() {
		return IP;
	}
	public void setIP(String ip) {
		IP = ip;
	}
}
