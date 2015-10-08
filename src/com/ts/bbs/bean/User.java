package com.ts.bbs.bean;

import java.sql.Date;

public class User {
	private int userid;
	private String username;
	private String password;
	private String sex;
	private String hobbys;
	//日期中只有年月日，使用Date类型 导java.sql.Date包
	private Date birthday;
	private String city;
	private String email;
	private String qq;
	//注册时间包含时分秒，此时对应的JAVA类使用String
	private String createtime;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getHobbys() {
		return hobbys;
	}
	public void setHobbys(String hobbys) {
		this.hobbys = hobbys;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	
	public String toString(){
		return this.userid+","+this.username+","+this.password+","+
	            this.sex+","+this.hobbys+","+this.birthday+","+
				this.city+","+this.email+","+this.qq+","+this.createtime;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
}
