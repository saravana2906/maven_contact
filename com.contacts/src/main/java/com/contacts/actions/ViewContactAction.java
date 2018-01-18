package com.contacts.actions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.contacts.services.ContactService;

import org.apache.struts2.interceptor.SessionAware;

import com.contacts.beans.Contact;
import com.contacts.beans.ContactPhone;
import com.opensymphony.xwork2.ActionSupport;

public class ViewContactAction extends ActionSupport implements SessionAware{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> userSession;
	public List<Contact> contacts;
	public HashMap<Long,ContactPhone> phones;
	public ContactService getConservice() {
		return conservice;
	}

	public void setConservice(ContactService conservice) {
		this.conservice = conservice;
	}

	public ContactService conservice;
	public String execute() throws Exception {
		
		conservice=new ContactService();
		this.contacts=conservice.getAllContacts(Long.parseLong((String) userSession.get("userid")));
		this.phones=conservice.getAllPhones(Long.parseLong((String) userSession.get("userid")));
		
		for(Contact contact : this.contacts)
		{
		System.out.println("Contact id" + contact.getContactid() +" "+contact.getName());
		ContactPhone phone=phones.get(contact.getContactid());
		if(phone.getPhoneid().size()>0)
		{
			List<Long> phid=phone.getPhoneid();
			List<String> ph=phone.getPhonenumber();
			for(int count=0;count<phone.getPhoneid().size();count++){
				System.out.println(phid.get(count)+"  "+ph.get(count));
			}
			
		}
		else
		{
			System.out.println("No phone number");
		}
			
		}
		
		return SUCCESS;
	}

	
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.userSession=session;
	}
	 
	
	

}
