package com.ts.bbs.service.impl;

import java.util.List;

import com.ts.bbs.bean.MessageBean;
import com.ts.bbs.bean.MessageInfoBean;
import com.ts.bbs.dao.MessageDao;
import com.ts.bbs.dao.impl.MessageDaoImpl;
import com.ts.bbs.service.MessageService;

public class MessageServiceImpl implements MessageService{
   //注入dao
	MessageDao msgdao = new MessageDaoImpl();
	@Override
	public boolean addMessage(MessageBean msg) {
		int result = msgdao.addMessage(msg);
		if(result>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean deleteMessage(int msgid) {
		int result = msgdao.deleteMessage(msgid);
		if(result>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean UpdateMessage(MessageBean msg) {
		int result = msgdao.UpdateMessage(msg);
		if(result>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public MessageBean findById(int msgid) {
		MessageBean msg = msgdao.findById(msgid);
		return msg;
	}

	@Override
	public boolean updateAccessCount(int msgid) {
		int result = msgdao.updateAccessCount(msgid);
		if(result>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public List<MessageInfoBean> findAll() {
		return msgdao.findAll();
	}

}
