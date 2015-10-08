package com.ts.bbs.service;

import java.util.List;

import com.ts.bbs.bean.MessageBean;
import com.ts.bbs.bean.MessageInfoBean;

public interface MessageService {
	   public boolean addMessage(MessageBean msg); //添加的新Message
		
		public boolean deleteMessage(int msgid);
		
		public boolean UpdateMessage(MessageBean msg);//根据编号修改的user
		
		public MessageBean findById(int msgid);	
		
		//修改指定留言的访问量
		public boolean updateAccessCount(int msgid);
		//查找所有留言信息，附带统计信息
		public List<MessageInfoBean> findAll();
}
