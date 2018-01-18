package com.contacts.dao;

import java.util.HashMap;


import com.contacts.beans.ContactPhone;

public interface ContactPhoneDao {
	boolean addPhoneno(ContactPhone phone);
	boolean deletePhoneno(long phoneid,long contactid);
	boolean deletePhoneno(long contactid);
	boolean updatePhoneno(long phoneid,String phoneno);
	HashMap<Long,ContactPhone> getAllUserPhones(long userid);
	ContactPhone getPhoneno(long contactid);

}
