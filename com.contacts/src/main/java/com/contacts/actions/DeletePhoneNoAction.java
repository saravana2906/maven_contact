package com.contacts.actions;

import com.contacts.dao.ContactPhoneDao;
import com.contacts.dao.ContactPhoneDaoImpl;
import com.opensymphony.xwork2.ActionSupport;

public class DeletePhoneNoAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long contactid;
	private long phoneid;
	private String phoneno;
	public long getContactid() {
		return contactid;
	}
	public void setContactid(long contactid) {
		this.contactid = contactid;
	}
	public long getPhoneid() {
		return phoneid;
	}
	public void setPhoneid(long phoneid) {
		this.phoneid = phoneid;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String deletePhoneno() throws Exception
	{
		System.out.println("Deletion "+ this.getContactid() + this.getPhoneid() + this.getPhoneno() );
		ContactPhoneDao cpdao=new ContactPhoneDaoImpl();
		cpdao.deletePhoneno(getPhoneid(), getContactid());
		return SUCCESS;
	}

}
