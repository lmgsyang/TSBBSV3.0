package com.ts.bbs.dao;

import java.util.List;

import com.ts.bbs.bean.User;

public interface UserDao {
	
	public int addUser(User user); //添加的新user
	
	public int deleteUser(int userid);
	
	public int UpdateUser(User user);//根据编号修改的user
	
	public User findById(int userid);
	
	public List<User> findAll();
	
	//用户登录
	public User userlogin(String username,String password);
	  
}
