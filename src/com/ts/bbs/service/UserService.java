package com.ts.bbs.service;

import java.util.List;

import com.ts.bbs.bean.User;

public interface UserService {
    
	public boolean addUser(User user); //添加的新user
	
	public boolean deleteUser(int id);
	
	public boolean UpdateUser(User user);//根据编号修改的user
	
	public User findById(int id);
	
	public List<User> findAll();
	
	//用户登录
	public User userlogin(String username,String password);
}
