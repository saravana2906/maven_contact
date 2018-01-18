package com.contacts.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction  extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> userSession;

	
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.userSession=session;
	}
	public String execute() throws Exception {
		userSession.clear();
		return SUCCESS;
	}
	
	

}
