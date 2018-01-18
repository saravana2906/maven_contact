package com.contacts.beans;

import com.contacts.forms.SignupForm;
import com.contacts.util.MD5util;


public class User {
	private long userid;
	private String username;
	private String emailid;
	private String phoneno;
	private String password;
	
	public User() {
		
			}
	public User(SignupForm signupForm) {
		this.username=signupForm.getUsername();
		this.emailid=signupForm.getEmailid();
		this.phoneno=signupForm.getPhoneno();
		this.password=MD5util.getMD5(signupForm.getPassword());
		
	}
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
