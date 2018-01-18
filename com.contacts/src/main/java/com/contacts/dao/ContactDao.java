package com.contacts.dao;

import java.util.List;

import com.contacts.beans.Contact;

public interface ContactDao {
	
	long addContact(Contact contact);
	boolean updateContact(Contact contact);
	boolean deleteContact(long contactid);
   List<Contact> getAllContacts(long userid);
Contact getContact(long contactid);
}
