package com.ts.bbs.service.impl;

import java.util.List;

import com.ts.bbs.bean.User;
import com.ts.bbs.dao.UserDao;
import com.ts.bbs.dao.impl.UserDaoImpl;
import com.ts.bbs.service.UserService;

public class UserServiceImpl implements UserService{
    //注入DAO对象(上转型对象,为了系统的扩展)
	UserDao userdao = new UserDaoImpl();
	
	@Override
	public boolean addUser(User user) {
		//调用dao的addUser方法
		int result = userdao.addUser(user);
		if(result>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean deleteUser(int id) {
		int result = userdao.deleteUser(id);
		if(result>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean UpdateUser(User user) {
		int result = userdao.UpdateUser(user);
		if(result>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public User findById(int id) {
		User user = userdao.findById(id);
		return user;
	}

	@Override
	public List<User> findAll() {
		List<User> list = userdao.findAll();
		return list;
	}

	@Override
	public User userlogin(String username, String password) {
		return userdao.userlogin(username, password);
	}

}
