package com.stock.entity;

public class User {
	
	
	public User(Integer id) {
		this.id = id;
	}
	public User(String userName) {
		this.userName = userName;
	}
	public User() {
	}

	private Integer id;
	private String name;//未实现，name,username
	private String userName;
	private String passWord;
	private String enabled;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	
	
	
	
	
}
