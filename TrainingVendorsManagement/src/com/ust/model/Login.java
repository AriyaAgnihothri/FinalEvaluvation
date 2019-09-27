package com.ust.model;

public class Login {
	private int user_Id;
	private String username;
	private String password;
	
	//Getters and Setters
	public int getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
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
	//Constructor using Fields
	public Login(int user_Id, String username, String password) {
		super();
		this.user_Id = user_Id;
		this.username = username;
		this.password = password;
	}
	//Constructor using Superclass
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	//toString
	@Override
	public String toString() {
		return "Login [user_Id=" + user_Id + ", username=" + username
				+ ", password=" + password + "]";
	}
	
	

}
