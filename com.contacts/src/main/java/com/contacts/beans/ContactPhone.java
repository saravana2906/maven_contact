package com.contacts.beans;

import java.util.List;

import com.contacts.forms.AddContactForm;

public class ContactPhone {
	List<String> phonenumber;
	long contactid;
	List<Long> phoneid;
	public List<Long> getPhoneid() {
		return phoneid;
	}
	public void setPhoneid(List<Long> phoneid) {
		this.phoneid = phoneid;
	}
	public ContactPhone() {
		
	}
	public ContactPhone(long temp_Contactid, AddContactForm contactform) {
		// TODO Auto-generated constructor stub
		this.contactid=temp_Contactid;
		this.phonenumber=contactform.getPhonenumber();
		
	}
	public List<String> getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(List<String> phonenumber) {
		this.phonenumber = phonenumber;
	}
	public long getContactid() {
		return contactid;
	}
	public void setContactid(long contactid) {
		this.contactid = contactid;
	}


}
