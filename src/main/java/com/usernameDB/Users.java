package com.usernameDB;

public class Users {

	private String userID = null;
	private String userName = null;
	private String realName = null;
	private String email = null;
	private String age = null;

	public Users() {
		super();
	}

	public String getUserID() {
		return userID;
	}
	
	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Users [userID=" + userID + ", userName=" + userName + ", realName=" + realName + ", email=" + email
				+ ", age=" + age + "]";
	}

}
