package com.ts.bbs.dao;

import java.util.List;

import com.ts.bbs.bean.*;

public interface ReplyDao {
   public int addReply(ReplyBean reply);
   //修改回复内容
   public int updateReplyContents(ReplyBean reply);
   //根据留言编号查找回复
   public List<ReplyBean> findReplyByMsgid(int msgid);
}
