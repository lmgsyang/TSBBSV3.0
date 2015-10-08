package com.ts.bbs.service.impl;

import com.ts.bbs.bean.Admin;
import com.ts.bbs.dao.AdminDao;
import com.ts.bbs.dao.impl.AdminDaoImpl;
import com.ts.bbs.service.AdminService;

public class AdminServiceImpl implements AdminService{
    AdminDao admindao = new AdminDaoImpl();
	@Override
	public Admin login(String adminname, String adminpassword) {
		Admin admin = admindao.login(adminname, adminpassword);
		return admin;
	}

}
