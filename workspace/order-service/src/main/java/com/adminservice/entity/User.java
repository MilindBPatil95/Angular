package com.adminservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;

import com.sun.istack.NotNull;

@Entity
public class User {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int userId;
@Pattern(regexp = "[A-Za-z]*")
private String userName;
@Pattern(regexp = "[1-9]*")
private int age;
@Pattern(regexp = "[a-zA-Z0-9_\\-\\.]+[@][a-z]+[\\.][a-z]{2,3}")
private String emailId;

   public User() {
	// TODO Auto-generated constructor stub
}
   
   
public User(int userId, String userName, int age, String emailId) {
	super();
	this.userId = userId;
	this.userName = userName;
	this.age = age;
	this.emailId = emailId;
}


@Override
public String toString() {
	return "User [userId=" + userId + ", userName=" + userName + ", age=" + age + ", emailId=" + emailId + "]";
}


public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}


}
