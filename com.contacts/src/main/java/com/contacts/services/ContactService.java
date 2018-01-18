package com.contacts.services;

import java.util.HashMap;
import java.util.List;

import com.contacts.beans.Contact;
import com.contacts.beans.ContactPhone;
import com.contacts.dao.ContactDaoImpl;
import com.contacts.dao.ContactPhoneDao;
import com.contacts.dao.ContactPhoneDaoImpl;

public class ContactService {
	
	public  List<Contact> getAllContacts(long userid) {
		// TODO Auto-generated method stub
		
		System.out.println(userid);
		ContactDaoImpl con=new ContactDaoImpl();
		
		return con.getAllContacts(userid);
	}

	public  HashMap<Long,ContactPhone> getAllPhones(long userid) {
		// TODO Auto-generated method stub
		ContactPhoneDao con=new ContactPhoneDaoImpl();
		System.out.println(userid);;
		return con.getAllUserPhones(userid);
	}

}
