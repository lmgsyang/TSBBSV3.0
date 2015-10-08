package com.ts.bbs.dao;

import com.ts.bbs.bean.Admin;

public interface AdminDao {
	//管理员登录
    public Admin login(String adminname,String adminpassword);
		  
}
