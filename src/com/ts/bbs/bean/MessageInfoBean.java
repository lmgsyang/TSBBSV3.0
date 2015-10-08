package com.ts.bbs.bean;
/**
 * 首页留言信息视图
 * @author yhy
 *
 */
public class MessageInfoBean {
	private int msgID; 
	private String msgTopic; 
	private int userID; 
	private String userName;
	private int accessCount;
	private int replyCount;
	private String msgTime;
	public int getMsgID() {
		return msgID;
	}
	public void setMsgID(int msgID) {
		this.msgID = msgID;
	}
	public String getMsgTopic() {
		return msgTopic;
	}
	public void setMsgTopic(String msgTopic) {
		this.msgTopic = msgTopic;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getAccessCount() {
		return accessCount;
	}
	public void setAccessCount(int accessCount) {
		this.accessCount = accessCount;
	}
	public int getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}
	public String getMsgTime() {
		return msgTime;
	}
	public void setMsgTime(String msgTime) {
		this.msgTime = msgTime;
	}
}
