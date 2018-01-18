package com.contacts.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.contacts.beans.Contact;
import com.contacts.beans.ContactPhone;
import com.contacts.dao.ContactDao;
import com.contacts.dao.ContactDaoImpl;
import com.contacts.dao.ContactPhoneDao;
import com.contacts.dao.ContactPhoneDaoImpl;
import com.contacts.forms.AddContactForm;
import com.opensymphony.xwork2.ActionSupport;

public class AddContactAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> userSession ;
	
	private AddContactForm contactform;

	public AddContactForm getContactform() {
		return contactform;
	}

	public void setContactform(AddContactForm contactform) {
		this.contactform = contactform;
	}

	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.userSession=session;
		
	}
	
	public String execute() throws Exception {
		
	/*	System.out.println(contactform.getName()+" "+contactform.getEmailid()+" ");
		for(String phone : contactform.getPhonenumber())
		{
			System.out.println(phone);
		}
		*/
		Contact contact=new Contact((String)userSession.get("userid"),contactform);
		ContactDao contactdao=new ContactDaoImpl();
		long temp_Contactid=contactdao.addContact(contact);
		System.out.println(temp_Contactid);
		ContactPhone phone=new ContactPhone(temp_Contactid,contactform);
		ContactPhoneDao phonedao=new ContactPhoneDaoImpl();
		if(phonedao.addPhoneno(phone))
		{
			return SUCCESS;
		}
		
		return ERROR;
		
	}

}
