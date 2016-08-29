package com.usernameDB;

public class Users {

	int userID = 0;
	String userName = null;
	String realName = null;
	String email = null;
	int age = 0;

	public Users() {
		super();
	}

	public int getUserID() {
		return userID;
	}
	
	public void setUserID(int userID) {
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Users [userID=" + userID + ", userName=" + userName + ", realName=" + realName + ", email=" + email
				+ ", age=" + age + "]";
	}

}
