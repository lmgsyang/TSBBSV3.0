package com.ts.bbs.service;

import java.util.List;

import com.ts.bbs.bean.ReplyBean;

public interface ReplyService {
	   //添加留言
	   public boolean addReply(ReplyBean reply);
	   //修改回复内容
	   public boolean updateReplyContents(ReplyBean reply);
	   //根据留言编号查找回复
	   public List<ReplyBean> findReplyByMsgid(int msgid);
}
