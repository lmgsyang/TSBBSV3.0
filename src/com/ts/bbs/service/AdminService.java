package com.ts.bbs.service;

import com.ts.bbs.bean.Admin;

public interface AdminService {
	//管理员登录
    public Admin login(String adminname,String adminpassword);
		  
}
