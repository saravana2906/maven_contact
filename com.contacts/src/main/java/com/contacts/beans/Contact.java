package com.contacts.beans;

import com.contacts.forms.AddContactForm;

public class Contact {
	
	public Contact() {
		    
	}

	public Contact(String userid, AddContactForm contactform) {
	// TODO Auto-generated constructor stub
		this.userid=Long.parseLong(userid);
		this.name=contactform.getName();
		this.emailid=contactform.getEmailid();
		
}
	private long contactid;
	private long userid;
	private String name;
	private String emailid;
	
	
	public long getContactid() {
		return contactid;
	}
	public void setContactid(long contactid) {
		this.contactid = contactid;
	}
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	

}
