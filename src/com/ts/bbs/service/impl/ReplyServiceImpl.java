package com.ts.bbs.service.impl;

import java.util.List;

import com.ts.bbs.bean.ReplyBean;
import com.ts.bbs.dao.ReplyDao;
import com.ts.bbs.dao.impl.ReplyDaoImpl;
import com.ts.bbs.service.ReplyService;

public class ReplyServiceImpl implements ReplyService{
    //注入dao 
	ReplyDao replydao = new ReplyDaoImpl();
	@Override
	public boolean addReply(ReplyBean reply) {
		int result = replydao.addReply(reply);
		if(result>0){
			
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean updateReplyContents(ReplyBean reply) {
		int result = replydao.updateReplyContents(reply);
		if(result>0){
			
			return true;
		}else{
			return false;
		}
	}

	@Override
	public List<ReplyBean> findReplyByMsgid(int msgid) {
		return replydao.findReplyByMsgid(msgid);
	}

}
