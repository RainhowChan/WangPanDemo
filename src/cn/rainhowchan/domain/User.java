package cn.rainhowchan.domain;

import java.util.Date;

public class User {
	private int id;
	private String username;
	private String password;
	private int gender;
	private Date birthdate;
	private String desc;
	
	public User(){}
	
	public User(String username, String password, int gender, Date birthdate,
			String desc) {
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.birthdate = birthdate;
		this.desc = desc;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
