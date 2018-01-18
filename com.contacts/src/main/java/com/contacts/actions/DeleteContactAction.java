package com.contacts.actions;

import java.util.Map;
import com.contacts.dao.ContactDao;
import com.contacts.dao.ContactDaoImpl;
import com.contacts.dao.ContactPhoneDao;
import com.contacts.dao.ContactPhoneDaoImpl;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteContactAction extends ActionSupport  {
	
	private String contactid;
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String execute() throws Exception {
		System.out.println("Contact ID :"+contactid);
		
		ContactDao condao=new ContactDaoImpl();
		boolean contact_flag=condao.deleteContact(Long.parseLong(contactid));
		ContactPhoneDao phonedao=new ContactPhoneDaoImpl();
		boolean phone_flag=phonedao.deletePhoneno(Long.parseLong(contactid));
		if(contact_flag && phone_flag)
		{
			return SUCCESS;
		}
		
		return ERROR;
		
	}
	public String getContactid() {
		return contactid;
	}
	public void setContactid(String contactid) {
		this.contactid = contactid;
	}

}
